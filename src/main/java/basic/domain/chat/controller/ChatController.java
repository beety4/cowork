package basic.domain.chat.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import basic.domain.chat.dto.ChatRoom;
import basic.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/ws")
@RequiredArgsConstructor
public class ChatController {
	private final ChatService chatService;
	
	// https://rhgustmfrh.tistory.com/15
	
	@PostMapping("/createChatRoom")
	@ResponseBody
	public ChatRoom createChatRoom(String roomName) {
		return chatService.createRoom(roomName);
	}
	
	@GetMapping("/showChatRoom")
	@ResponseBody
	public List<ChatRoom> findAllRoom() {
		return chatService.findAllRoom();
	}

	
	
}
