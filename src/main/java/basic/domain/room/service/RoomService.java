package basic.domain.room.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.room.mapper.RoomMapper;
import basic.domain.room.dto.RoomBoardDTO;
import basic.domain.room.dto.RoomDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {
	private final RoomMapper roomMapper;
	
	public String getRoomType(int roomNo) {
		return roomMapper.getRoomType(roomNo);
	}
	
	public Object getRoomBoard(int roomNo) {
		if(getRoomType(roomNo).equals("BOARD")) {
			return roomMapper.getRoomBoardList(roomNo);
		} else {
			return null;
		}
	}
	
	public void createBoard(RoomBoardDTO roomBoardDTO) {
		roomMapper.createBoard(roomBoardDTO);
	}
	
	public void createRoom(RoomDTO roomDTO) {
		roomMapper.createRoom(roomDTO);
	}
}
