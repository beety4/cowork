package basic.domain.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import basic.domain.email.service.EmailService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmailController {
	private final EmailService emailservice;
	
	@ResponseBody
	@PostMapping("/sendmail")
	public String sendmail(String email) {
		String authKey = emailservice.sendMail(email);
		return authKey;
	}
	
}
