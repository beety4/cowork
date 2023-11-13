package basic.domain.room.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import basic.domain.room.dto.RoomBoardDTO;
import basic.domain.room.dto.RoomDTO;

@Mapper
public interface RoomMapper {
	public String getRoomType(int roomNo);
	public ArrayList<RoomBoardDTO> getRoomBoardList(int roomNo);
	public void createBoard(RoomBoardDTO roomBoardDTO);
	public void createRoom(RoomDTO roomDTO);
}
