package basic.domain.like.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import basic.domain.like.dto.LikeDTO;
import basic.domain.like.service.LikeService;
import basic.domain.security.config.PrincipalDetails;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LikeController {
	private final LikeService likeService;
	
	@ResponseBody
	@PostMapping("/likeAction.do")
	public List<Integer> likeAction(@AuthenticationPrincipal PrincipalDetails details, LikeDTO likeDTO) {
		likeDTO.setName(details.getName());
		List<Integer> a = likeService.likeAction(likeDTO);
		
		for(int b : a) {
			System.out.println(b);
		}
		
		return a;
	}
	
}
