package basic.domain.room.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
}
