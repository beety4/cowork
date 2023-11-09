package basic.domain.space.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.space.dto.SpaceDTO;
import basic.domain.space.dto.SpaceUserDTO;
import basic.domain.space.mapper.SpaceMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SpaceService {
	private final SpaceMapper spaceMapper;
	
	public void createSpace(SpaceDTO spaceDTO) {
		if(spaceDTO.getSpaceImg() == null) {
			spaceDTO.setSpaceImg("/assets/space/default.png");
		}
		spaceMapper.createSpace(spaceDTO);
		
		int spaceNo = spaceMapper.getLastSpaceNo();
		SpaceUserDTO spaceUserDTO = new SpaceUserDTO(spaceNo, spaceDTO.getOwner());
		spaceMapper.addSpaceMember(spaceUserDTO);
	}
	
	public void addSpaceMember(SpaceUserDTO spaceUserDTO) {
		spaceMapper.addSpaceMember(spaceUserDTO);
	}
	
	public ArrayList<SpaceDTO> getSpaceByName(String name) {
		return spaceMapper.getSpaceByName(name);
	}
	
	public boolean isIncludeSpace(SpaceUserDTO spaceUserDTO) {
		return (spaceMapper.isIncludeSpace(spaceUserDTO) != null);
	}
	
	
}
