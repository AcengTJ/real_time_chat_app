/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.service;

import com.project.realtimechatapplication.controller.AuthenticationController;
import com.project.realtimechatapplication.dto.RegisterDTO;
import com.project.realtimechatapplication.repository.UserRepository;
import com.project.realtimechatapplication.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: UserService.java, v 0.1 2024‐10‐31 17:19 Aceng Exp $$
 */
@Service
public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    private UserRepository userRepository;

    public User registerUser(RegisterDTO registerDTO) {
        if (userRepository.existsByPhone(registerDTO.getPhone())) {
            throw new RuntimeException("Phone number already exist");
        }

        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);

        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public boolean authenticate(String phone) {
        try {
            boolean exists = userRepository.existsByPhone(phone);

            if (exists) {
                logger.info("Phone number found: {}", phone);
                return true;
            }

            logger.info("Phone number not found: {}", phone);
            return false;
        } catch (Exception e) {
            logger.error("Authentication Error", e);
            return false;
        }
    }
}
