package com.spring.example.websocket;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String payload = message.getPayload();
		JSONObject jsonObject = new JSONObject(payload);
		session.sendMessage(new TextMessage("Hi "+jsonObject.get("user")+" how may I help you?"));
	}
	
	
}
