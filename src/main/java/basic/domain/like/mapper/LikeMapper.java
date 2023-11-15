package basic.domain.like.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import basic.domain.like.dto.LikeDTO;
import basic.domain.like.dto.LikeTypeDTO;

@Mapper
public interface LikeMapper {
	public void addLike(LikeDTO likeDTO);
	public Integer isChecked(LikeDTO likeDTO);
	public ArrayList<LikeTypeDTO> getLike(LikeDTO likeDTO);
	public void deleteLike(LikeDTO likeDTO);
}
