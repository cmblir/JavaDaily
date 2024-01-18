package hello.itemservice.web.validation.form;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemUpdateForm {
	
	@NotNull
	private Long id;
	
	@NotBlank
	private String itemName;
	
	@NotNull
	@Range(min = 1000, max = 1000000)
	private Integer price;
	
	//수정에서는 수량은 자유롭게 변경할 수 있다.
	private Integer quantity;

}
