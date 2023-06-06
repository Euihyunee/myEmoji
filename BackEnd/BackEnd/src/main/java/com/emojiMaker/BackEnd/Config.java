package com.emojiMaker.BackEnd;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    private String connectPath = "/imagePath/**";
    private String resourcePath = "file:///home/ec2-user/img/";
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("classpath:/static/img/");
    }
}
