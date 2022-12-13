package com.green.nowon.messaging;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    // 메모리기반 메세지 브로커가 접두사가 붙은 목적지에서 클라이언트에게 인사말 메세지를 다시 전달할 수 있도록 호출
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");   //controller @MessageMapping() 앞에붙는 prefixes
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //js var socket = new SockJS('/my-websocket')
        registry.addEndpoint("/my-websocket").withSockJS();     //자바스크립트의 웹소켓 페이지url과 일치해야함
    }

}