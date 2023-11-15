package basic.domain.like.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.like.dto.LikeDTO;
import basic.domain.like.dto.LikeTypeDTO;
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
	
	public int isChecked(LikeDTO likeDTO) {
		if(likeMapper.isChecked(likeDTO) == null) {
			return -1;
		}
		return likeMapper.isChecked(likeDTO);
	}
	
	public ArrayList<LikeTypeDTO> getLike(LikeDTO likeDTO) {
		ArrayList<LikeTypeDTO> list = likeMapper.getLike(likeDTO);
		ArrayList<LikeTypeDTO> remake = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			LikeTypeDTO likeTypeDTO = new LikeTypeDTO(i, 0);
			remake.add(likeTypeDTO);
		}
		
		if(list.size() != 0) {
			for(int i=0; i<list.size(); i++) {
				remake.set(list.get(i).getLikeType(), list.get(i));
			}
		}
		return remake;
	}
	
	
	public void deleteLike(LikeDTO likeDTO) {
		likeMapper.deleteLike(likeDTO);
	}
	
	public ArrayList<LikeTypeDTO> likeAction(LikeDTO likeDTO) {
		int getType = isChecked(likeDTO);
		if(getType == likeDTO.getLikeType()) {
			deleteLike(likeDTO);
		} else if(getType == -1) {
			addLike(likeDTO);
		}
		return getLike(likeDTO);
	}
	
}
