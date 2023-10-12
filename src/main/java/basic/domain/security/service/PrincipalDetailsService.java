package basic.domain.security.service;

//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import basic.domain.security.config.PrincipalDetails;
import basic.domain.sign.dto.UserDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
	private final SecurityService service;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		UserDTO userDTO = service.getOwninfo(id);
		
		if(userDTO == null) {
			return null;
		}
		
		return new PrincipalDetails(userDTO);
	}
}
