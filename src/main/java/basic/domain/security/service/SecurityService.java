package basic.domain.security.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.security.mapper.SecurityMapper;
import basic.domain.sign.dto.UserDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class SecurityService {
	private final SecurityMapper mapper;
	
	public UserDTO getOwninfo(String id) {
		return mapper.getOwninfo(id);
	}
}
