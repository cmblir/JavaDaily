package hello.itemservice.web.validation.form;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class ItemSaveForm {
	
	@NotBlank
	private String itemName;
	
	@NotNull
	@Range(min = 1000, max = 1000000)
	private Integer price;
	
	@NotNull
	@Max(9999)
	private Integer quantity;

}
