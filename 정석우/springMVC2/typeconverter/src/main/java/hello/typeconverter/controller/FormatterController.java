package hello.typeconverter.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FormatterController {

	@GetMapping("/formatter/edit")
	public String formatterForm(Model model) {
		Form form = new Form();
		form.setNumber(10000);
		form.setLocalDateTime(LocalDateTime.now());
		model.addAttribute("form",form);
		return "formatter-form";
	}
	
	@PostMapping("/formatter/edit")
	public String formatterEdit(@ModelAttribute Form form) {
		log.info("number = {}",form.getNumber());
		log.info("dateTime = {}", form.getLocalDateTime());
		return "formatter-view";
	}
	
	@Getter
	@Setter
	@RequiredArgsConstructor
	static class Form {
		@NumberFormat(pattern = "###,###")
		private Integer number;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime localDateTime;
	}
}
