package basic.domain.room.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import basic.domain.room.dto.RoomBoardDTO;
import basic.domain.room.dto.RoomDTO;
import basic.domain.room.service.RoomService;
import basic.domain.security.config.PrincipalDetails;
import basic.domain.space.service.SpaceService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RoomController {
	private final SpaceService spaceService;
	private final RoomService roomService;
	
	@ResponseBody
	@PostMapping("/showRoom.do")
	public Object showRoom(String value) {
		int roomNo = Integer.parseInt(value);
		return roomService.getRoomBoard(roomNo);
	}
	
	@PostMapping("/createBoard.do")
	public String createBoard(@AuthenticationPrincipal PrincipalDetails details, Model m, RoomBoardDTO roomBoardDTO, int spaceNo) {
		roomBoardDTO.setName(details.getName());
		roomBoardDTO.setCategory("TMP");
		
		roomService.createBoard(roomBoardDTO);
		return "redirect:/showSpace.do?spaceNo=" + spaceNo;
	}
	
	@PostMapping("/createRoom.do")
	public String createRoom(@AuthenticationPrincipal PrincipalDetails details, Model m, RoomDTO roomDTO, int spaceNo) {
		roomDTO.setSpaceNo(spaceNo);
		
		roomService.createRoom(roomDTO);
		return "redirect:/showSpace.do?spaceNo=" + spaceNo;
	}
	
}
