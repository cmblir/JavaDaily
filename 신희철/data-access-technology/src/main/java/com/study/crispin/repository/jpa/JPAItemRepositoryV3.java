package com.study.crispin.repository.jpa;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.crispin.domain.Item;
import com.study.crispin.domain.QItem;
import com.study.crispin.repository.ItemRepository;
import com.study.crispin.repository.ItemSearchCond;
import com.study.crispin.repository.ItemUpdateDto;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

import static com.study.crispin.domain.QItem.item;

@Repository
@Transactional
public class JPAItemRepositoryV3 implements ItemRepository {

    private final SpringDataJPAItemRepository repository;
    private final JPQLQueryFactory query;

    public JPAItemRepositoryV3(SpringDataJPAItemRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.query = new JPAQueryFactory(entityManager);
    }

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDto updateParam) {
        Item item = repository.findById(itemId).orElseThrow();
        item.update(updateParam);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    public List<Item> oldFindAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        QItem item = QItem.item;
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (StringUtils.hasText(itemName)) {
            booleanBuilder.and(item.itemName.like("%" + itemName + "%"));
        }
        if (maxPrice != null) {
            booleanBuilder.and(item.price.loe(maxPrice));
        }

        return query.select(QItem.item)
                .from(QItem.item)
                .where(booleanBuilder)
                .fetch();
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        return query.select(item)
                .from(item)
                .where(likeItemName(itemName), maxPrice(maxPrice))
                .fetch();
    }

    private BooleanExpression likeItemName(String itemName) {
        if (StringUtils.hasText(itemName)) {
            return item.itemName.like("%" + itemName + "%");
        }
        return null;
    }

    private BooleanExpression maxPrice(Integer maxPrice) {
        if (maxPrice != null) {
            return item.price.loe(maxPrice);
        }
        return null;
    }
}
