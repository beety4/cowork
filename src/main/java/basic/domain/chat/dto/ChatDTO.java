package basic.domain.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatDTO {
	private int chatNo;
	private int roomNo;
	private String name;
	private String message;
	private String time;
	private String messageType;
}
