package basic.domain.space.controller;

import java.util.ArrayList;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import basic.domain.room.dto.RoomDTO;
import basic.domain.security.config.PrincipalDetails;
import basic.domain.space.dto.SpaceDTO;
import basic.domain.space.dto.SpaceUserDTO;
import basic.domain.space.service.SpaceService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SpaceController {
	private final SpaceService spaceService;
	
	public void sideBar(String name, Model m) {
		ArrayList<SpaceDTO> spaceList = spaceService.getSpaceByName(name);
		m.addAttribute("spaceList", spaceList);
	}
	
	@GetMapping("/mainPage.do")
	public String mainPage(@AuthenticationPrincipal PrincipalDetails details, Model m) {
		// 왼쪽 space목록 반환
		String name = details.getName();
		sideBar(name, m);
		return "mainPage";
	}
	
	@GetMapping("/showSpace.do")
	public String selectSpace(@AuthenticationPrincipal PrincipalDetails details, Model m, int spaceNo) {
		// 왼쪽 space목록 반환
		String name = details.getName();
		sideBar(name, m);
		
		// 현재 유저가 spaceNo에 접근할때, 해당 space에 존재하는지 확인
		SpaceUserDTO spaceUserDTO = new SpaceUserDTO(spaceNo, name);
		if(spaceService.isIncludeSpace(spaceUserDTO) == false) {
			return "mainPage";
		}
		
		// 선택한 space의 room목록 반환
		ArrayList<RoomDTO> roomList = spaceService.getRoom(spaceNo);
		SpaceDTO spaceDTO = spaceService.getSpace(spaceNo);
		m.addAttribute("roomList", roomList);
		m.addAttribute("spaceDTO", spaceDTO);
		return "showSpace";
	}
	
	@GetMapping("createSpace.do")
	public String createSpace(@AuthenticationPrincipal PrincipalDetails details, Model m) {
		// 왼쪽 space목록 반환
		String name = details.getName();
		sideBar(name, m);
		return "createSpace";
	}
	@PostMapping("createSpace.do")
	public String createSpace(@AuthenticationPrincipal PrincipalDetails details, Model m, SpaceDTO spaceDTO, MultipartFile file) {
		// 왼쪽 space목록 반환
		String name = details.getName();
		sideBar(name, m);
		
		// space 소유자 설정 후, 생성
		spaceDTO.setOwner(name);
		int spaceNo = spaceService.createSpace(spaceDTO, file);
		
		return "redirect:/showSpace.do?spaceNo=" + spaceNo;
	}
	
	
	
}
