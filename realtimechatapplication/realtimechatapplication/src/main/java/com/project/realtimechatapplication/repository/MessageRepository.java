/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.repository;

import com.project.realtimechatapplication.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: MessageRepository.java, v 0.1 2024‐10‐27 18:46 Aceng Exp $$
 */
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findTop50ByOrderByTimestampDesc();
}