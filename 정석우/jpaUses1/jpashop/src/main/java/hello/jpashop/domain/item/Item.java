package hello.jpashop.domain.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import hello.jpashop.domain.category.Category;
import hello.jpashop.domain.exception.NotEnoughStockException;
import hello.jpashop.domain.order.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

	@Id @GeneratedValue
	@Column(name="item_id")
	private Long id;
	
	@OneToMany(mappedBy = "item")
	private List<OrderItem> orderItems = new ArrayList<>();
	
	private String name;
	
	private int price;
	
	private int stockQuantity;
	
	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();
	
	
	// 비즈니스 로직
	
	/*
	 * stock 증가
	 */
	public void addStock(int quantity) {
		this.stockQuantity += quantity;
	}
	
	/*
	 * stock 감소
	 */
	public void removeStock(int quantity) {
		int restStock = this.stockQuantity - quantity;
		if(restStock < 0) {
			throw new NotEnoughStockException("need more stock");
		}
		this.stockQuantity = restStock;
	}
	
	
}
