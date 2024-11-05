/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.controller;

import com.project.realtimechatapplication.repository.MessageRepository;
import com.project.realtimechatapplication.model.Message;
import com.project.realtimechatapplication.model.MsgType;
import com.project.realtimechatapplication.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: ChatController.java, v 0.1 2024‐10‐18 16:45 Aceng Exp $$
 */
@Controller
@RequiredArgsConstructor
public class ChatController {
    private final MessageRepository messageRepository;
    private final MessageService messageService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("chat.sendMessage")
    @SendTo("/topic/chat")
    public Message sendMsg(@Payload Message msg) {
        if (msg.getType().equals("CHAT") && msg.getContent() == null) {
            msg.setContent("");
        }

        messageService.saveMessage(msg);
        return msg;
    }

    @MessageMapping("chat.addUser")
    @SendTo("/topic/chat")
    public Message addUser(@Payload Message msg, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", msg.getSender());

        msg.setContent(msg.getSender() + " joined");
        return messageRepository.save(msg);
    }
}
