package basic.domain.chat.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

import basic.domain.chat.service.ChatService;
import lombok.Builder;
import lombok.Data;

@Data
public class ChatRoom {
	private int roomNo;
	private String roomName;
	private String roomType;
	
	private String name; 
	private Set<WebSocketSession> sessions = new HashSet<>();
	
	@Builder
	public ChatRoom(int roomNo, String name) {
		this.roomNo = roomNo;
		this.name = name;
	}
	
	public void handleActions(WebSocketSession session, ChatDTO chatDTO, ChatService chatService) {
		if(chatDTO.getType().equals("ENTER")) {
			sessions.add(session);
			chatDTO.setMessage((chatDTO.getName() + "님이 입장하셨습니다."));
		}
		sendMessage(chatDTO, chatService);
	}
	
	public <T> void sendMessage(T message, ChatService chatService) {
		sessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
	}
}
