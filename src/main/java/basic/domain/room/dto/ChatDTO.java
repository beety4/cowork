package basic.domain.room.dto;

import lombok.Data;

@Data
public class ChatDTO {
	private String id;
	private int state;
	private String content;
}
