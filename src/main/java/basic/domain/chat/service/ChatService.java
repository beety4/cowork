package basic.domain.chat.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.chat.dto.ChatDTO;
import basic.domain.chat.mapper.ChatMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatService {
	private final ChatMapper chatMapper;
	
	public int getLastRoomNo() {
		return chatMapper.getLastRoomNo() + 1;
	}
	
	public ArrayList<ChatDTO> getChatList(int roomNo) {
		return chatMapper.getChatList(roomNo);
	}
	
	public void saveChat(ChatDTO chatDTO) {
		chatMapper.saveChat(chatDTO);
	}
	
}
