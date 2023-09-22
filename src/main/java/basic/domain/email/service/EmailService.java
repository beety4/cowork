package basic.domain.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import basic.domain.email.config.CreateKey;

@Service
public class EmailService {
	private final JavaMailSender javaMailSender;
	private static final String SENDER = "202244016@itc.ac.kr";
	private static String authKey;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public MimeMessage writeMSG(String sendTo) {
		authKey = CreateKey.newKey();
		
		MimeMessage msg = javaMailSender.createMimeMessage();
		
		try {
			msg.setFrom(SENDER);
			System.out.println(sendTo);
			msg.setRecipients(MimeMessage.RecipientType.TO, sendTo);
			msg.setSubject("[Cowork] 이메일 인증");
			String mailText = "";
			mailText += "<h3> 인증번호 </h3><br>";
			mailText += "<h1>" + authKey + "</h1><br>";
			mailText += "<h1> 끝! </h1>";
			msg.setText(mailText, "UTF-8", "html");
		} catch ( MessagingException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public String sendMail(String sendTo) {
		MimeMessage msg = writeMSG(sendTo);
		javaMailSender.send(msg);
		return authKey;
	}
}
