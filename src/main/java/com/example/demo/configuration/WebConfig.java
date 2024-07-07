package com.example.demo.configuration;

import com.example.demo.handler.SystemIdInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SystemIdInterceptor())
                .addPathPatterns("/other/**");  // 攔截/other之下的全部路徑
    }
}
