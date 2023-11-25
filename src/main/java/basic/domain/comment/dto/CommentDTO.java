package basic.domain.comment.dto;

import lombok.Data;

@Data
public class CommentDTO {
	private int commentNo;
	private int boardNo;
	private String name;
	private String content;
}
