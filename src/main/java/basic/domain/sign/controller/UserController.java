package basic.domain.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import basic.domain.sign.dto.UserDTO;
import basic.domain.sign.service.UserService;

@Controller
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/sign-in.do")
	public String signin() {
		return "login";
	}
	@PostMapping("/sign-in.do")
	public String signin2(String id, String password) {
		boolean result = userService.loginAction(id, password);
		return result ? "index" : "404";
	}
	
	@GetMapping("/sign-up.do")
	public String signup() {
		return "register";
	}
	@PostMapping("/sign-up.do")
	public String signup2(UserDTO userDTO) {
		userService.setUserDTO(userDTO);
		return "index";
	}
}
