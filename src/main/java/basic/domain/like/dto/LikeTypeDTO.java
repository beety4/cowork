package basic.domain.like.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeTypeDTO {
	private int likeType;
	private int cnt;
}
