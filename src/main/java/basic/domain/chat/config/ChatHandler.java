package basic.domain.chat.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import basic.domain.chat.dto.ChatDTO;
import basic.domain.chat.dto.ChatRoom;
import basic.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {
	private final ObjectMapper objectMapper;
	private final ChatService chatService;
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		ChatDTO chatDTO = objectMapper.readValue(payload, ChatDTO.class);
		ChatRoom room = chatService.findRoomById(chatDTO.getRoomNo());
		room.handleActions(session, chatDTO, chatService);
	}
	
	
}
