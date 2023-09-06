package basic.domain.sign.dto;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class UserDTO {
	private String id;
	private String password;
	private String name;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private LocalDate birth;
	
	private String gender;
	private String phone;
	private String email;
	private String emailhash;
	private int emailcheck;
	private String joindate;
	private String img;
}
