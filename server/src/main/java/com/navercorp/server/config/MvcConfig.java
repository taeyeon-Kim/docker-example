package com.navercorp.server.config;

import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    private ResourceProperties resourceProperties = new ResourceProperties();

    @Bean
    public ViewResolver getViewResolver() {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
        viewResolver.setCache(false);
        viewResolver.setPrefix("classpath:/templates/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String staticPathPatterns[] = new String[]{"/**/*.js", "/**/*.png"
                , "/**/*.jpg", "/**/*.swf", "/**/*.css", "/**/*.html", "/**/*.gif"};
        registry.addResourceHandler(staticPathPatterns)
                .addResourceLocations(this.resourceProperties.getStaticLocations());
    }
}