package basic.domain.sign.mapper;

import org.apache.ibatis.annotations.Mapper;
import basic.domain.sign.dto.UserDTO;

@Mapper
public interface UserMapper {
	public UserDTO getUserDTO();
	public void setUserDTO(UserDTO userDTO);
	public String getPassword(String id);
}
