package org.example.webservice.config;

import lombok.RequiredArgsConstructor;
import org.example.webservice.config.auth.LoginUserArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserArgumentResolver);
    }
}

/**
 * LoginUserArgumentResolver 가 인식될 수 있도록 WebMvcConfigurer 를 구현한 클래스를 생성하고
 * addArgumentResolvers method 를 override 하여 추가해줌
 */