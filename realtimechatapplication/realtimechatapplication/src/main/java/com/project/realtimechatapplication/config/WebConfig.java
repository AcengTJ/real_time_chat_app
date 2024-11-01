/**
 * aniboys.id
 * Copyright (c) 2017-2024 All Rights Reserved.
 */
package com.project.realtimechatapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Aceng <acengtjhin69@aniboys.id>
 * @version $Id: WebConfig.java, v 0.1 2024‐10‐18 18:06 Aceng Exp $$
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
