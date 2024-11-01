/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.controller;

import com.project.realtimechatapplication.dto.LoginDTO;
import com.project.realtimechatapplication.dto.RegisterDTO;
import com.project.realtimechatapplication.model.User;
import com.project.realtimechatapplication.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: AuthenticationController.java, v 0.1 2024‐10‐31 17:12 Aceng Exp $$
 */
@RestController
@RequestMapping("/api/users")
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> regsiterUser(@Valid @RequestBody RegisterDTO registerDTO) {
        User resgiteredUser = authService.registerUser(registerDTO);
        return ResponseEntity.ok("Registration was successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        boolean isAuthenticated = authService.authenticate(loginDTO.getPhone());

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unknown phone number.");
        }
    }
}
