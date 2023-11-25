package basic.domain.like.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.like.dto.LikeCntDTO;
import basic.domain.like.dto.LikeDTO;
import basic.domain.like.dto.RoomUserDTO;
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
	
	public Integer isChecked(LikeDTO likeDTO) {
		return likeMapper.isChecked(likeDTO);
	}
	
	public void deleteLike(LikeDTO likeDTO) {
		likeMapper.deleteLike(likeDTO);
	}
	
	public int deleteAfterCnt(LikeDTO likeDTO) {
		return likeMapper.deleteAfterCnt(likeDTO);
	}
	
	public boolean likeAction(LikeDTO likeDTO) {
		if(isChecked(likeDTO) == null) {
			addLike(likeDTO);
			return true;
		} else if(isChecked(likeDTO) == likeDTO.getLikeType()){
			deleteLike(likeDTO);
			if(deleteAfterCnt(likeDTO) == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
		
	public ArrayList<LikeCntDTO> getLikeCntALL(RoomUserDTO ruDTO) {
		return likeMapper.getLikeCntALL(ruDTO);
	}
	
	public ArrayList<LikeCntDTO> getLikeActionCntALL(RoomUserDTO ruDTO, LikeDTO likeDTO) {
		ArrayList<LikeCntDTO> list = new ArrayList<>();
		if(likeAction(likeDTO) == false) {
			LikeCntDTO likeCntDTO = new LikeCntDTO();
			likeCntDTO.setBoardNo(likeDTO.getBoardNo());
			likeCntDTO.setLikeType(likeDTO.getLikeType());
			likeCntDTO.setCnt(0);
			likeCntDTO.setTF(0);
		
			list.add(likeCntDTO);
		} else {
			list.addAll(likeMapper.getLikeCntALL(ruDTO));
		}
		
		return list;
	}
	
}
