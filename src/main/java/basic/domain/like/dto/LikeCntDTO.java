package basic.domain.like.dto;

import lombok.Data;

@Data
public class LikeCntDTO {
	private int boardNo;
	private int likeType;
	private int cnt;
	private int TF;
}
