package basic.domain.space.controller;

import java.util.ArrayList;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import basic.domain.security.config.PrincipalDetails;
import basic.domain.sign.service.UserService;
import basic.domain.space.dto.SpaceDTO;
import basic.domain.space.dto.SpaceUserDTO;
import basic.domain.space.service.SpaceService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SpaceController {
	private final SpaceService spaceService;
	private final UserService userService;
	
	@GetMapping("/mainPage")
	public String mainPage(@AuthenticationPrincipal PrincipalDetails details, Model m) {
		ArrayList<SpaceDTO> spaceList = spaceService.getSpaceByName(details.getName());
		
		// spaceList 출력
		m.addAttribute("spaceList", spaceList);
		return "mainPage";
	}
	
	@GetMapping("/selectSpace")
	public String selectSpace(@AuthenticationPrincipal PrincipalDetails details, Model m, int spaceNo) {
		// 현재 유저가 spaceNo에 접근할때, 해당 space에 존재하는지 확인
		SpaceUserDTO spaceUserDTO = new SpaceUserDTO(spaceNo, details.getName());
		if(spaceService.isIncludeSpace(spaceUserDTO)) {
			return "mainPage";
		}
		
		
		// 선택 space 들의 room 반환 필요
		m.addAttribute("","");	
		return "spacePage";
	}
	
	@GetMapping("createSpace")
	public String createSpace() {
		return "createSpace";
	}
	@PostMapping("createSpace")
	public String createSpace(@AuthenticationPrincipal PrincipalDetails details, Model m, SpaceDTO spaceDTO) {
		spaceDTO.setOwner(details.getName());
		spaceService.createSpace(spaceDTO);
		return "redirect:/selectSpace?" + spaceDTO.getSpaceNo();
	}
	
}
