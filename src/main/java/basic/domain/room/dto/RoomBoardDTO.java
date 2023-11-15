package basic.domain.room.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.format.annotation.DateTimeFormat;

import basic.domain.like.dto.LikeTypeDTO;
import lombok.Data;

@Data
public class RoomBoardDTO {
	private int boardNo;
	private int roomNo;
	private String name;
	private String title;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private LocalDate date;
	
	private String category;
	private String content;
	private int available;
	
	private ArrayList<LikeTypeDTO> likeType;
	
}
