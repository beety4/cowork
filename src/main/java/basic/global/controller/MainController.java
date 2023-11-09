package basic.global.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import basic.domain.security.config.PrincipalDetails;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {	
	@GetMapping("/")
	public String intro(@AuthenticationPrincipal PrincipalDetails details) {
		if(details == null) {
			return "intro";
		} else {
			return "redirect:/mainPage";
		}
	}

	@GetMapping("/404")
	public String err() {
		return "404";
	}
	
	
	@GetMapping("custom")
	public String custom() {
		return "custom";
	}
	
	
	
	
	
	
	@GetMapping("/blank")
	public String blank(@AuthenticationPrincipal PrincipalDetails details) {
		System.out.println(details.getName());
		return "reference/blank";
	}
	@GetMapping("/buttons")
	public String buttons(HttpSession s) {
		System.out.println(s.getAttribute("sID"));
		return "reference/buttons";
	}
	@GetMapping("/cards")
	public String cards() {
		return "reference/cards";
	}
	@GetMapping("/charts")
	public String charts() {
		return "reference/charts";
	}
	@GetMapping("/tables")
	public String tables() {
		return "reference/tables";
	}
	@GetMapping("/utilities-animation")
	public String util1() {
		return "reference/utilities-animation";
	}
	@GetMapping("/utilities-border")
	public String util2() {
		return "reference/utilities-border";
	}
	@GetMapping("/utilities-color")
	public String util3() {
		return "reference/utilities-color";
	}
	@GetMapping("/utilities-other")
	public String util4() {
		return "reference/utilities-other";
	}
}
