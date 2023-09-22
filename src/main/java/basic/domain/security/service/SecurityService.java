package basic.domain.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basic.domain.security.mapper.SecurityMapper;
import basic.domain.sign.dto.UserDTO;

@Service
public class SecurityService {
	private SecurityMapper mapper;
	
	@Autowired
	public SecurityService(SecurityMapper mapper) {
		this.mapper = mapper;
	}
	
	public UserDTO getOwninfo(String id) {
		return mapper.getOwninfo(id);
	}
}
