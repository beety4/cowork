package basic.domain.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basic.domain.security.config.PrincipalDetails;
import basic.domain.security.mapper.SecurityMapper;
import basic.domain.sign.dto.UserDTO;
import basic.domain.sign.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PricipalOauth2UserService extends DefaultOAuth2UserService {
	private final SecurityMapper mapper;
	private final UserMapper userMapper;
	private final BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		//System.out.println(super.loadUser(userRequest).getAttributes());
		OAuth2User oauth2User = super.loadUser(userRequest);
		
		String provider = userRequest.getClientRegistration().getClientId();
		String providerId = oauth2User.getAttribute("sub");
		String id = provider + "_" + providerId;
		String password = bcryptEncoder.encode("blablabla");
		String email = oauth2User.getAttribute("email");
		
		UserDTO userDTO = mapper.getOwninfo(providerId);
		if(userDTO == null) {
			userDTO = UserDTO.builder()
					.id(providerId)
					.password(password)
					.name(email)
					.birth(null)
					.gender("M")
					.email(email)
					.build();
			userMapper.insertUserDTO(userDTO);
		}
		return new PrincipalDetails(userDTO, oauth2User.getAttributes());
	}
}
