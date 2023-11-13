package basic.domain.room.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RoomChatMsgDTO {
	private String id;
	private int state;
	private String content;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private LocalDate date;
}
