package com.study.crispin.repository.jdbctemplate;

import com.study.crispin.domain.Item;
import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.ItemSearchCond;
import com.study.crispin.repository.ItemUpdateDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JdbcTemplateRepositoryV1 implements ItemRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateRepositoryV1(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Item save(Item item) {
        String sql = "insert into item(item_name, price, quantity) values(?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            // 자동 증가 키
            PreparedStatement preparedStatement = connection.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, item.getItemName());
            preparedStatement.setInt(2, item.getPrice());
            preparedStatement.setInt(3, item.getQuantity());
            return preparedStatement;
        }, keyHolder);

        long key = Objects.requireNonNull(keyHolder.getKey()).longValue();
        item.setId(key);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        String sql = "update item set item_name = ?, price = ?, quantity = ? where id = ?";
        jdbcTemplate.update(
                sql,
                updateParam.getItemName(),
                updateParam.getPrice(),
                updateParam.getQuantity(),
                itemId
        );
    }

    @Override
    public Optional<Item> findById(Long id) {
        String sql = "select id, item_name, price, quantity from item where id = ?";
        try {
            Item item = jdbcTemplate.queryForObject(sql, itemRowMapper(), id);
            return Optional.of(item);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        String sql = "select id, item_name, price, quantity from item";

        // 동적 쿼리
        if (StringUtils.hasText(itemName) || maxPrice != null) {
            sql += " where";
        }

        boolean andFlag = false;
        List<Object> param = new ArrayList<>();
        if (StringUtils.hasText(itemName)) {
            sql += " item_name like concat('%', ?, '%')";
            param.add(itemName);
            andFlag = true;
        }

        if (maxPrice != null) {
            if (andFlag) {
                sql += " and";
            }
            sql += " price <= ?";
            param.add(maxPrice);
         }

        return jdbcTemplate.query(sql, itemRowMapper(), param.toArray());
    }

    private RowMapper<Item> itemRowMapper() {
        return (resultSet, rowNumber) -> {
            Item item = new Item();
            item.setId(resultSet.getLong("id"));
            item.setItemName(resultSet.getString("item_name"));
            item.setPrice(resultSet.getInt("price"));
            item.setQuantity(resultSet.getInt("quantity"));
            return item;
        };
    }
}
