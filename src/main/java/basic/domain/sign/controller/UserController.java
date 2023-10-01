package basic.domain.sign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import basic.domain.sign.dto.UserDTO;
import basic.domain.sign.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/sign")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/sign-in.do")
	public String signin() {
		return "login";
	}
	
	@GetMapping("/sign-up.do")
	public String signup() {
		return "register";
	}
	@PostMapping("/sign-up.do")
	public String signup2(UserDTO userDTO) {
		userService.insertUserDTO(userDTO);
		return "login";
	}
}
