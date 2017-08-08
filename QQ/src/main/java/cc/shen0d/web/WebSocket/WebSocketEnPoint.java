package cc.shen0d.web.WebSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import cc.shen0d.pojo.entity.User;

public class WebSocketEnPoint implements WebSocketHandler {
	Map<String, WebSocketSession> cacheUserSession = new HashMap<String, WebSocketSession>();

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Map<String, Object> handshakeAttributes = session.getHandshakeAttributes();
		User user = (User) handshakeAttributes.get("user");
		System.out.println("websocket接入" + user.getUsername());
		TextMessage textMessage = new TextMessage(user.getUsername().equals("神")
				? "尊贵的" + user.getUsername() + "进入房间" : user.getUsername() + "进入房间");
		sendAll(textMessage);
		if (user != null) {
			if (!cacheUserSession.containsKey(user.getUsername())) {
				cacheUserSession.put(user.getUsername(), session);
			} else {
				TextMessage textMessage1 = new TextMessage(user.getUsername().equals("神")
						? "尊贵的" + user.getUsername() + "被挤掉了" : user.getUsername() + "被挤掉了");
				sendAll(textMessage1);
				// 取出session 并且关闭
				WebSocketSession webSocketSession = cacheUserSession.get(user.getUsername());
				webSocketSession.close();
				// 再放入新的
				cacheUserSession.put(user.getUsername(), session);
			}
		}
	}

	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message)
			throws Exception
	{
		String[] s = { "英俊潇洒的", "高端大气的", "一表人才的", "玉树临风的", "气宇不凡的" };
		String[] b = { "饔飧不给的", "身无寸缕的", "绳枢瓮牖的", "百拙千丑的 ", "惨不忍睹的" };
		if (message instanceof TextMessage) {
			// 处理文字类消息
			Map<String, Object> handshakeAttributes = session.getHandshakeAttributes();
			User user = (User) handshakeAttributes.get("user");
			String msg = user.getUsername().equals("神")
					? s[new Random().nextInt(5)] + user.getUsername() + ":"
							+ message.getPayload().toString()
					: b[new Random().nextInt(5)] + user.getUsername() + ":"
							+ message.getPayload().toString();
			TextMessage textMessage = new TextMessage(msg);
			sendAll(textMessage);
		}
	}

	public void handleTransportError(WebSocketSession session, Throwable exception)
			throws Exception
	{

	}

	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
			throws Exception
	{
		Map<String, Object> handshakeAttributes = session.getHandshakeAttributes();
		User user = (User) handshakeAttributes.get("user");
		System.out.println("websocket断开" + user.getUsername());
		if (user != null) {
			if (cacheUserSession.containsKey(user.getUsername())) {
				cacheUserSession.remove(user.getUsername());
			}
		}
		TextMessage textMessage = new TextMessage(user.getUsername() + "退出房间");
		sendAll(textMessage);

	}

	public boolean supportsPartialMessages() {
		return false;
	}

	public void sendAll(WebSocketMessage message) {
		Collection<WebSocketSession> values = cacheUserSession.values();
		for (WebSocketSession webSocketSession : values) {
			try {
				System.out.println(webSocketSession);
				InetSocketAddress localAddress = webSocketSession.getLocalAddress();
				System.out.println(localAddress);
				webSocketSession.sendMessage(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sendMsg(WebSocketSession session) {

	}
}
