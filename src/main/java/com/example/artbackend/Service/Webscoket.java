package com.example.artbackend.Service;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker
public class Webscoket implements  WebSocketMessageBrokerConfigurer  {


        @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic" );
        config.setApplicationDestinationPrefixes("/app"); 
    }
 
  
      
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint( "/ws")
        .setAllowedOrigins("http://localhost:4200", "http://localhost:8101" ,  "https://localhost", "ionic://localhost")
            .withSockJS();
    }

}
