package com.solution.pmt.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${uploadPath.path}")
    String uploadPath;

    @Value("${url.path}")
    String urlPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // urlPath로 입력하면 uploadPath로 변환
        // ex) /file
        registry.addResourceHandler(urlPath)
                .addResourceLocations(uploadPath);
    }
}
