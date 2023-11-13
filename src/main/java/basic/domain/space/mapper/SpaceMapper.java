package basic.domain.space.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import basic.domain.room.dto.RoomDTO;
import basic.domain.space.dto.SpaceDTO;
import basic.domain.space.dto.SpaceUserDTO;

@Mapper
public interface SpaceMapper {
	public void createSpace(SpaceDTO spaceDTO);
	public void addSpaceMember(SpaceUserDTO spaceUserDTO);
	public ArrayList<SpaceDTO> getSpaceByName(String name);
	public Integer isIncludeSpace(SpaceUserDTO spaceUserDTO);
	public ArrayList<RoomDTO> getRoom(int spaceNo);
	public Integer getLastSpaceNo();
	public void createSampleRoomData1(int spaceNo);
	public void createSampleRoomData2(int spaceNo);
	public SpaceDTO getSpace(int spaceNo);
}
