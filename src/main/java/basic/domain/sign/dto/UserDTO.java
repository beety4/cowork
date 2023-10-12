package basic.domain.sign.dto;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
	private String id;
	private String password;
	private String name;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private LocalDate birth;
	
	private String gender;
	private String email;
	private String joindate;
	private String img;
	private String depart;
	private String roles;
}
