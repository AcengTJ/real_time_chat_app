/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: UserDTO.java, v 0.1 2024‐10‐31 17:22 Aceng Exp $$
 */
@Data
public class RegisterDTO {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Phone number is required")
    private String phone;

    private String role = "USER";

    private LocalDateTime createdAt;

}
