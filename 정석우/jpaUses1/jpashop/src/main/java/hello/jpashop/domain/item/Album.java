package hello.jpashop.domain.item;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import hello.jpashop.domain.order.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("A")
public class Album extends Item {
	private String artist;

	private String etc;
}
