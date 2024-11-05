/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: Message.java, v 0.1 2024‐10‐18 16:46 Aceng Exp $$
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "messages")
public class Message {
    @Id
    private  String id;

    private MsgType type;

    private String content;

    private String sender;

    private LocalDateTime timestamp;
}
