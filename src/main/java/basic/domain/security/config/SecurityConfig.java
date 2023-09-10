package basic.domain.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {        
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
				.anyRequest().authenticated());
//		http.formLogin(login -> login
//			.loginPage("sign-in.do")
//			.loginProcessingUrl("sign-in.do")
//			.usernameParameter("id")
//			.passwordParameter("pw")
//			.defaultSuccessUrl("/", true)
//			.permitAll());

		return http.build();
	}

}
