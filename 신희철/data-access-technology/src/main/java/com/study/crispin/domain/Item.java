package com.study.crispin.domain;

import com.study.crispin.repository.ItemUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item update(ItemUpdateDto updateParam) {
        this.itemName = updateParam.getItemName();
        this.price = updateParam.getPrice();
        this.quantity = updateParam.getQuantity();
        return this;
    }
}

