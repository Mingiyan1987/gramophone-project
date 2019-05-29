package com.geekbrains.gramophone.configs;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
@PropertySource("classpath:private.properties")
@ComponentScan("com.geekbrains.gramophone")
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        if (!registry.hasMappingForPattern("/images/**")) {
            registry.addResourceHandler("/images/**")
                    .addResourceLocations("file:images/");
        }

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

//    @Bean
//    public LocaleResolver localeResolver() {
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(new Locale("ru"));
//        return sessionLocaleResolver;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//        lci.setParamName("lang");
//        return lci;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }

    // TODO ??? нужно ли, вроде и без настройки этого бина работает ???
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        DataSize size = DataSize.ofMegabytes(10);
//        factory.setMaxFileSize(size);
//        factory.setMaxRequestSize(size);
//        return factory.createMultipartConfig();
//    }
}