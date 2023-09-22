package basic.domain.security.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import basic.domain.security.service.SecurityService;
import basic.domain.sign.dto.UserDTO;

@Component
public class UserDetailConfig implements UserDetailsService {
	private SecurityService service;
	
	public UserDetailConfig(SecurityService service) {
		this.service = service;
	}
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		UserDTO userDTO = service.getOwninfo(id);
		
		return User.builder()
				.username(userDTO.getId())
				.password(userDTO.getPassword())
				.roles(userDTO.getRoles())
				.build();
	}
}
