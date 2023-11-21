package basic.domain.chat.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {
	public int getLastRoomNo();
}
