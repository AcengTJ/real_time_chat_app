/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.service;

import com.project.realtimechatapplication.repository.MessageRepository;
import com.project.realtimechatapplication.model.Message;
import com.project.realtimechatapplication.model.MsgType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: WebsocketEventListener.java, v 0.1 2024‐10‐18 16:35 Aceng Exp $$
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class WebsocketEventListener {

    private final MessageRepository messageRepository;
    private final SimpMessageSendingOperations messageOperations;
    @EventListener
    public void handleWebsocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if (Objects.nonNull(username)) {
            log.info("user disconnected {}", username);

            Message leaveMessage = Message.builder()
                            .type(MsgType.LEAVE)
                            .sender(username)
                            .content(username + " left the chat")
                            .timestamp(LocalDateTime.now())
                            .build();

            messageRepository.save(leaveMessage);

            messageOperations.convertAndSend("/topic/chat", leaveMessage);
        }
    }
}
