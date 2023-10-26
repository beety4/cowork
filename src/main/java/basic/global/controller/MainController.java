package basic.global.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import basic.domain.security.config.PrincipalDetails;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@GetMapping("/")
	//public String index(@AuthenticationPrincipal PrincipalDetails pd, HttpSession s) {
	public String index() {
//		if(pd == null) {
//			s.setAttribute("sID", null);
//		} else {
//			s.setAttribute("sID", pd.getName());
//		}
		//s.setAttribute("sID", null);
		return "index";
	}
	

	@GetMapping("/404")
	public String err() {
		return "404";
	}
	
	
	@GetMapping("/blank")
	public String blank(@AuthenticationPrincipal PrincipalDetails details) {
		System.out.println(details.getName());
		return "blank";
	}
	
	
	
	@GetMapping("/buttons")
	public String buttons(HttpSession s) {
		System.out.println(s.getAttribute("sID"));
		return "buttons";
	}
	@GetMapping("/cards")
	public String cards() {
		return "cards";
	}
	@GetMapping("/charts")
	public String charts() {
		return "charts";
	}
	@GetMapping("/forgot-password")
	public String forgot() {
		return "forgot-password";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("/tables")
	public String tables() {
		return "tables";
	}
	@GetMapping("/utilities-animation")
	public String util1() {
		return "utilities-animation";
	}
	@GetMapping("/utilities-border")
	public String util2() {
		return "utilities-border";
	}
	@GetMapping("/utilities-color")
	public String util3() {
		return "utilities-color";
	}
	@GetMapping("/utilities-other")
	public String util4() {
		return "utilities-other";
	}
}
