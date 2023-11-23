package basic.domain.chat.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import basic.domain.chat.dto.ChatDTO;
import basic.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/ws")
@RequiredArgsConstructor
public class ChatController {
	private final ChatService chatService;
	
	// 메세지 DB 저장하는 비동기식 처리
	@PostMapping("/saveChat.do")
	@ResponseBody
	public int saveChat(ChatDTO chatDTO) {
		chatService.saveChat(chatDTO);
		return 1;
	}

	//목록
	@PostMapping("/showChat.do")
	@ResponseBody
	public ArrayList<ChatDTO> showChat(int roomNo) {
		return chatService.getChatList(roomNo);
	}
	
}
