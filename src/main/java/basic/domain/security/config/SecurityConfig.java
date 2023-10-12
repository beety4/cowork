package basic.domain.security.config;

import java.util.stream.Stream;

import jakarta.servlet.DispatcherType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import basic.domain.security.service.PricipalOauth2UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	PricipalOauth2UserService service;
	
	private static final String[] PERMIT_URL = new String[] {
		"/", "/assets/**", "/css/**", "/img/**", "/js/**", "/scss/**", "/vender/**"
		, "/sign/*", "/charts", "404", "/sendmail"
	};
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {        
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((auth) -> auth
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers(
					Stream
				        .of(PERMIT_URL)
				        .map(AntPathRequestMatcher::antMatcher)
				        .toArray(AntPathRequestMatcher[]::new)
				).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/cards")).hasRole("USERa")
				.anyRequest().authenticated())
			
			.formLogin((login) -> login
				.loginPage("/sign/sign-in.do")
				.loginProcessingUrl("/sign/sign-in.do")
				.usernameParameter("id")
				.passwordParameter("password")
				.defaultSuccessUrl("/", true)
				.failureUrl("/404")
				.permitAll())
			.logout((logout) -> logout
				.logoutSuccessUrl("/")
				.permitAll())
			
			.oauth2Login((oauth) -> oauth
                .loginPage("/sign/sign-in.do")
                .defaultSuccessUrl("/", true)
                .userInfoEndpoint((userInfo) -> userInfo
                		.userService(service)));

		return http.build();
	}

}
