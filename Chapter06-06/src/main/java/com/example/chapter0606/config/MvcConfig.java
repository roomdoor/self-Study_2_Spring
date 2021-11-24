package com.example.chapter0606.config;

import com.example.chapter0606.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {


    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");  // 특정 url 만 선택하거나 제외하는 것도 가능 (addPathPatterns, excludePathPatterns
    }
}
