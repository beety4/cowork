package basic.domain.sign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import basic.domain.sign.dto.UserDTO;
import basic.domain.sign.mapper.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
	private UserMapper userMapper;
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	public UserService(UserMapper userMapper, BCryptPasswordEncoder bcryptEncoder) {
		this.userMapper = userMapper;
		this.bcryptEncoder = bcryptEncoder;
	}
	
	public void insertUserDTO(UserDTO userDTO) {
		String secure = bcryptEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(secure);
		userMapper.insertUserDTO(userDTO);
	}
}
