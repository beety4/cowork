package basic.domain.chat.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import basic.domain.chat.dto.ChatDTO;

@Mapper
public interface ChatMapper {
	public int getLastRoomNo();
	public ArrayList<ChatDTO> getChatList(int roomNo);
	public void saveChat(ChatDTO chatDTO);
	
}
