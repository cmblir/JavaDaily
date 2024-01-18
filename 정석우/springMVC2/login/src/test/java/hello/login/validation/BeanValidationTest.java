package hello.login.validation;

import java.util.Set;

import org.junit.jupiter.api.Test;

import hello.login.domain.item.Item;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class BeanValidationTest {

	
	@Test
	void beanValidation() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Item item = new Item();
		item.setItemName(" ");
		item.setPrice(0);
		item.setQuantity(100000);
		
		Set<ConstraintViolation<Item>> violations = validator.validate(item);
		for(ConstraintViolation<Item> violation : violations) {
			System.out.println("violation = " + violation);
			System.out.println("violation = " + violation.getMessage());
		}
	}
}
