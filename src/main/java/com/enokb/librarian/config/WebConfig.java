package com.enokb.librarian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @program: librarian
 * @description:
 * @author: ksewen
 * @create: 2018-03-17 18:11
 **/

public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        pathMatcher.setCaseSensitive(false);
        configurer.setPathMatcher(pathMatcher);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.enokb.librarian.controller"))
                .paths(PathSelectors.any()).build().useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("librarian") // 任意，请稍微规范点
                // .description("") 任意，请稍微规范点
                .termsOfServiceUrl("http://localhost:7799/swagger-ui.html") // 将“url”换成自己的ip:port
                .contact(new Contact("enok", "http://www.enok.com", "enok@enok-b.com")).version("1.1.0").build();
    }
}
