package basic.domain.like.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import basic.domain.like.dto.LikeCntDTO;
import basic.domain.like.dto.LikeDTO;
import basic.domain.like.dto.RoomUserDTO;

@Mapper
public interface LikeMapper {
	public void addLike(LikeDTO likeDTO);
	public Integer isChecked(LikeDTO likeDTO);
	public void deleteLike(LikeDTO likeDTO);
	public int deleteAfterCnt(LikeDTO likeDTO);
	public ArrayList<LikeCntDTO> getLikeCntALL(RoomUserDTO ruDTO);
}
