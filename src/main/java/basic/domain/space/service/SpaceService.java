package basic.domain.space.service;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import basic.domain.room.dto.RoomDTO;
import basic.domain.space.dto.SpaceDTO;
import basic.domain.space.dto.SpaceUserDTO;
import basic.domain.space.mapper.SpaceMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SpaceService {
	private final SpaceMapper spaceMapper;
	
	public int createSpace(SpaceDTO spaceDTO, MultipartFile file) {
		// 생성될 space의 No를 마지막 spaceNo + 1 로 예측지정
		
		int lastSpaceNo = getLastSpaceNo() + 1;
		
		// 파일을 첨부 시
		if(file.isEmpty() == false) {
			// 파일 경로 및 확장자 처리
			String realPath = "C:/Users/sysop/eclipse-workspace/cowork/src/main/resources/static/space";
			String fileName = StringUtils.cleanPath(file.getOriginalFilename()); // 파일 원본 이름
			String fileExtension = StringUtils.getFilenameExtension(fileName);	 // 확장자
			UUID uuid = UUID.randomUUID();							// 랜덤 UUID
			String newFileName = uuid + "." + fileExtension;		// 저장할 파일 이름
			File newFile = new File(realPath + "/" + newFileName);	// 저장할 파일 객체
			
			// 파일 업로드
			try {
				file.transferTo(newFile);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			// 파일 경로 DTO에 저장
			spaceDTO.setSpaceImg(newFileName);
		} else {
			// 파일 미첨부 시
			spaceDTO.setSpaceImg("default.png");
		}
		
		// space 만들기
		spaceMapper.createSpace(spaceDTO);
		
		// space 기본 데이터 세팅 (소유자 member추가, 기본 게시판 추가, 기본 채팅방 추가)
		SpaceUserDTO spaceUserDTO = new SpaceUserDTO(lastSpaceNo, spaceDTO.getOwner());
		spaceMapper.addSpaceMember(spaceUserDTO);
		spaceMapper.createSampleRoomData1(lastSpaceNo);
		spaceMapper.createSampleRoomData2(lastSpaceNo);
		return lastSpaceNo;
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
	
	public int getLastSpaceNo() {
		if(spaceMapper.getLastSpaceNo() == null) {
			return 0;
		} else {
			return spaceMapper.getLastSpaceNo();
		}
	}
	
	public ArrayList<RoomDTO> getRoom(int spaceNo) {
		return spaceMapper.getRoom(spaceNo);
	}
	
	public SpaceDTO getSpace(int spaceNo) {
		return spaceMapper.getSpace(spaceNo);
	}
	
}
