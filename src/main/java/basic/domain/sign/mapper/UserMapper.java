package basic.domain.sign.mapper;

import org.apache.ibatis.annotations.Mapper;
import basic.domain.sign.dto.UserDTO;

@Mapper
public interface UserMapper {
	public void insertUserDTO(UserDTO userDTO);
}
