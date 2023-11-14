package basic.domain.like.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.like.dto.LikeDTO;
import basic.domain.like.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LikeService {
	private final LikeMapper likeMapper;
	
	public void addLike(LikeDTO likeDTO) {
		likeMapper.addLike(likeDTO);
	}
	
	public boolean isChecked(LikeDTO likeDTO) {
		if(likeMapper.isChecked(likeDTO) == null) {
			return false;
		}
		return true;
	}
	
	public List<Integer> getLike(LikeDTO likeDTO) {
		return likeMapper.getLike(likeDTO);
	}
	
	public void deleteLike(LikeDTO likeDTO) {
		likeMapper.deleteLike(likeDTO);
	}
	
	public List<Integer> likeAction(LikeDTO likeDTO) {
		deleteLike(likeDTO);
		addLike(likeDTO);
		return getLike(likeDTO);
	}
	
}
