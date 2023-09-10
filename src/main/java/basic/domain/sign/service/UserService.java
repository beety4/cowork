package basic.domain.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import basic.domain.sign.dto.UserDTO;
import basic.domain.sign.mapper.UserMapper;

@Service
public class UserService {
	private UserMapper userMapper;
	
	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public UserDTO getUserDTO() {
		return userMapper.getUserDTO();
	}
	
	public void setUserDTO(UserDTO userDTO) {
		userMapper.setUserDTO(userDTO);
	}
	
	public boolean loginAction(String id, String password) {
		String DBpw = userMapper.getPassword(id);
		if(DBpw == null) {
			return false;
		}
		String ENCpw = password;	// Encrypt 추가 필요
		return DBpw.equals(ENCpw) ? true : false;
	}
}
