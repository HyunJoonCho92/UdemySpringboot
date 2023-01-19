package websocket0119_2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class ChatWebSocketConfig implements WebSocketConfigurer {
	
	// /ws 요청시 ChatWebSocketHandler에 매칭
	private final WebSocketHandler handler;
	
	public ChatWebSocketConfig(WebSocketHandler handler) {
		super();
		this.handler = handler;
	}
	
	
	@Override
	public void registerWebSocketHandlers
				(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addHandler(handler, "/ws") //
				.setAllowedOrigins("*");
	}

}
