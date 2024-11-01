/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: User.java, v 0.1 2024‐10‐25 16:38 Aceng Exp $$
 */
@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    private String username;

    private String phone;

    private String role;

    private boolean isActive = true;

    @CreatedDate
    private LocalDateTime createdAt;
}
