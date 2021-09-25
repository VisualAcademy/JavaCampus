package com.hawaso.javacampus.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 컨트롤러를 따로 만들지 않고 라우팅(경로)과 뷰 페이지 연결 
        registry.addViewController("/learn").setViewName("views/learn");
        registry.addViewController("/quickstart").setViewName("views/quickstart");
        registry.addViewController("/guides").setViewName("views/guides");
    }
}
