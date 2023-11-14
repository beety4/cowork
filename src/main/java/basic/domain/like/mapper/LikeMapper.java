package basic.domain.like.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import basic.domain.like.dto.LikeDTO;

@Mapper
public interface LikeMapper {
	public void addLike(LikeDTO likeDTO);
	public Integer isChecked(LikeDTO likeDTO);
	public List<Integer> getLike(LikeDTO likeDTO);
	public void deleteLike(LikeDTO likeDTO);
}
