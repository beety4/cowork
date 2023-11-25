package basic.domain.like.controller;

import java.util.ArrayList;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import basic.domain.like.dto.LikeCntDTO;
import basic.domain.like.dto.LikeDTO;
import basic.domain.like.dto.RoomUserDTO;
import basic.domain.like.service.LikeService;
import basic.domain.security.config.PrincipalDetails;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LikeController {
	private final LikeService likeService;
	
	@ResponseBody
	@PostMapping("/getLikeCntALL.do")
	public ArrayList<LikeCntDTO> getLikeByRoomNo(@AuthenticationPrincipal PrincipalDetails details, int roomNo) {
		RoomUserDTO ruDTO = new RoomUserDTO(roomNo, details.getName());
		return likeService.getLikeCntALL(ruDTO);
	}
	
	@ResponseBody
	@PostMapping("/likeAction.do")
	public ArrayList<LikeCntDTO> addLike(@AuthenticationPrincipal PrincipalDetails details, LikeDTO likeDTO, int roomNo) {
		String name = details.getName();
		likeDTO.setName(name);
		
		RoomUserDTO ruDTO = new RoomUserDTO(roomNo, details.getName());
		return likeService.getLikeActionCntALL(ruDTO, likeDTO);
	}
	
}
