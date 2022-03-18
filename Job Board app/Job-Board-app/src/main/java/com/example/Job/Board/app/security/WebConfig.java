
package com.example.Job.Board.app.security;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Web Config.
 */
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    private CorsRegistry registry;

    /**
     * To Add Cors Mappings.
     * @param registry registry
     */
    @Override
    public void addCorsMappings(final @NotNull CorsRegistry registry) {
        this.registry = registry;
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "OPTIONS", "HEAD",
                        "PUT", "PATCH", "DELETE", "TRACE")
                .allowedHeaders("*")
                .maxAge(86400)
                .exposedHeaders("Authorization");
    }

}
