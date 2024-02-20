package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
// @Data 좀 위험..! 예제니까 그냥 사용
//@Getter
//@Setter

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price=0;
    private Integer quantity =0;

    public Item(){

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
