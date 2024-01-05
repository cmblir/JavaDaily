package com.study.crispin.repository.v2;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.crispin.domain.Item;
import com.study.crispin.repository.ItemSearchCond;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.study.crispin.domain.QItem.item;

@Repository
public class ItemQueryRepositoryV2 {

    private final JPQLQueryFactory query;

    public ItemQueryRepositoryV2(EntityManager entityManager) {
        this.query = new JPAQueryFactory(entityManager);
    }

    public List<Item> findAll(ItemSearchCond cond) {
        return query.select(item)
                .from(item)
                .where(
                        likeItemName(cond.getItemName()),
                        maxPrice(cond.getMaxPrice())
                )
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
