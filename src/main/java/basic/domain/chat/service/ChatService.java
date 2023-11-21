package basic.domain.chat.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import basic.domain.chat.dto.ChatRoom;
import basic.domain.chat.mapper.ChatMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatService {
	private final ObjectMapper objectMapper;
	private Map<Integer, ChatRoom> chatRooms;
	private final ChatMapper chatMapper;
	
	@PostConstruct
	private void init() {
		chatRooms = new LinkedHashMap<>();
	}
	
	public List<ChatRoom> findAllRoom() {
		return new ArrayList<>(chatRooms.values());
	}
	
	public ChatRoom findRoomById(int roomNo) {
		return chatRooms.get(roomNo);
	}
	
	public ChatRoom createRoom(String roomName) {
		int lastNo = getLastRoomNo();
		ChatRoom chatRoom = ChatRoom.builder()
				.roomNo(lastNo)
				.name("test")
				.build();
		chatRooms.put(lastNo, chatRoom);
		return chatRoom;
		
	}

	public int getLastRoomNo() {
		return chatMapper.getLastRoomNo() + 1;
	}
	
	public <T> void sendMessage(WebSocketSession session, T message) {
		try {
			session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
