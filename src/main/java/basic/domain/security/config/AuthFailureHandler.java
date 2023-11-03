package basic.domain.security.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class AuthFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		String err = "0";
		if(exception instanceof BadCredentialsException) {
			err = "101";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			err = "102";
		} else if(exception instanceof UsernameNotFoundException) {
			err = "103";
		} else if(exception instanceof AuthenticationCredentialsNotFoundException) {
			err = "104";
		} else {
			err = "105";
		}
		
		
		
		response.sendRedirect("/sign/sign-in.do?err=" + err);
	}
	
}
