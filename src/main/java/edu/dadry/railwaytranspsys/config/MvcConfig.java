package edu.dadry.railwaytranspsys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/signin").setViewName("login");
        registry.addViewController("/signup").setViewName("register");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/customer").setViewName("customerCreation");
    }
}
