package basic.domain.security.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import basic.domain.security.service.SecurityService;
import basic.domain.sign.dto.UserDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDetailConfig implements UserDetailsService {
	private final SecurityService service;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		UserDTO userDTO = service.getOwninfo(id);
		
		if(userDTO == null) throw new UsernameNotFoundException("Not FOUND");
		
		return User.builder()
				.username(userDTO.getId())
				.password(userDTO.getPassword())
				.roles(userDTO.getRoles())
				.build();
	}
}
