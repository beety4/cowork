package basic.domain.sign.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.sign.dto.UserDTO;
import basic.domain.sign.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
	private final UserMapper userMapper;
	private final BCryptPasswordEncoder bcryptEncoder;
	
	public void insertUserDTO(UserDTO userDTO) {
		String secure = bcryptEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(secure);
		userMapper.insertUserDTO(userDTO);
	}
}
