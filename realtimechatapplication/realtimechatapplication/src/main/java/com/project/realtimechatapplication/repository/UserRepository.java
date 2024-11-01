/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.repository;

import com.project.realtimechatapplication.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: UserRepository.java, v 0.1 2024‐10‐31 17:13 Aceng Exp $$
 */
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByPhone(String phone);
    boolean existsByUsername(String username);

    Optional<User> findByPhone(String phone);
}