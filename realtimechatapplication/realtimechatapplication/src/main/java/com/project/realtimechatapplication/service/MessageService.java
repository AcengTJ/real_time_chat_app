/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.service;

import com.project.realtimechatapplication.model.Message;
import com.project.realtimechatapplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: MessageService.java, v 0.1 2024‐11‐05 16:47 Aceng Exp $$
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
