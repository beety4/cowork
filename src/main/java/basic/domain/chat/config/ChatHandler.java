package basic.domain.chat.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import basic.domain.chat.dto.ChatDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {
	private final ObjectMapper objectMapper;
    private final Set<WebSocketSession> sessions = new HashSet<>();
    private final Map<Integer,Set<WebSocketSession>> chatRoomSessionMap = new HashMap<>();

    // 소켓 연결
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("연결됨 : " + session.getId());
        String a = session.getPrincipal().getName();
        System.out.println(a);
        sessions.add(session);
    }

    // 메세지 송수신
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 데이터(메세지)를 가져와 JSON -> DTO 변환
    	String payload = message.getPayload();
        ChatDTO ChatDTO = objectMapper.readValue(payload, ChatDTO.class);

        int roomNo = ChatDTO.getRoomNo();
        // 메모리 상에 채팅방에 대한 세션 없으면 만들어줌
        if(chatRoomSessionMap.containsKey(roomNo) == false){
            chatRoomSessionMap.put(roomNo,new HashSet<>());
        }
        Set<WebSocketSession> chatRoomSession = chatRoomSessionMap.get(roomNo);

        // messageType이 ENTER일 경우 session을 sessions에 넣음
        if (ChatDTO.getMessageType().equals("ENTER")) {
            chatRoomSession.add(session);
        }
        
        // ChatDTO(메세지)를 접속중인 사람에게 전송
        sendMessageToChatRoom(ChatDTO, chatRoomSession);
    }

    // 소켓 종료 확인
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("!!!연결끊김 : " + session.getId());
        if(chatRoomSessionMap.get(session) != null) {
        	removeClosedSession(sessions);
        	sessions.remove(session);
        }
    }
    

    // 메모리상에서도 삭제
    private void removeClosedSession(Set<WebSocketSession> chatRoomSession) {
        chatRoomSession.removeIf(sess -> !sessions.contains(sess));
    }

    // 메세지 보내기 sendMessage 함수 실행
    private void sendMessageToChatRoom(ChatDTO ChatDTO, Set<WebSocketSession> chatRoomSession) {
        chatRoomSession.parallelStream().forEach(sess -> sendMessage(sess, ChatDTO));//2
    }

    // 각 세션에게 메세지 전송
    public <T> void sendMessage(WebSocketSession session, T message) {
        try{
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
