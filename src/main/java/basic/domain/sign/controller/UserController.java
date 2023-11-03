package basic.domain.sign.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import basic.domain.security.config.PrincipalDetails;
import basic.domain.sign.dto.UserDTO;
import basic.domain.sign.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/sign")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/sign-in.do")
	public String signin(@AuthenticationPrincipal PrincipalDetails details) {
		if(details == null) {
			return "login";
		} else {
			return "redirect:/mainPage";
		}
	}
	
	@GetMapping("/sign-up.do")
	public String signup(@AuthenticationPrincipal PrincipalDetails details) {
		if(details == null) {
			return "register";
		} else {
			return "redirect:/mainPage";
		}
		
	}
	@PostMapping("/sign-up.do")
	public String signup2(UserDTO userDTO, Model m) {
		try {
			userService.insertUserDTO(userDTO);
		} catch(Exception e) {
			e.printStackTrace();
			m.addAttribute("err", "121");
		}
		return "login";
	}
	
	@GetMapping("/forgot-password.do")
	public String forgot(@AuthenticationPrincipal PrincipalDetails details) {
		if(details == null) {
			return "forgot-password";
		} else {
			return "redirect:/mainPage";
		}
	}
}
