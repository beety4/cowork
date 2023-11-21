package basic.domain.chat.dto;

import lombok.Data;

@Data
public class ChatDTO {
	private int chatNo;
	private int roomNo;
	private String name;
	private String message;
	private String time;
	private String type;
}
