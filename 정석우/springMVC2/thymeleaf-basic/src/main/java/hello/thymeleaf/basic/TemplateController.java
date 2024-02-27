package hello.thymeleaf.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

	@GetMapping("fragment")
	public String template(Model model) {
		return "template/fragment/fragmentMain";
	}
	
	@GetMapping("layout")
	public String layout(Model model) {
		return "template/layout/layoutMain";
	}
	
	@GetMapping("/layoutExtend")
	public String layoutExtend(Model model) {
		return "template/layoutExtend/layoutExtendMain";
	}
}
