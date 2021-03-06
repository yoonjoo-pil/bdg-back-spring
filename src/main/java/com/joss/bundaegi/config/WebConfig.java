package com.joss.bundaegi.config;

import lombok.extern.slf4j.Slf4j;
import net.rakugakibox.util.YamlResourceBundle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Configuration
public class WebConfig {
    /*
        Bean 등록을 위한 필수 설정
        1. 리소스 파일의 경로
        2. 리소스 파일의 인코딩 타입
        3. 리소스를 리로딩할 간격
        4. 제공하지 않는 언어로 요청이 들어왔을 때 대신 보여줄 언어
     */
//    @Bean
//    public LocaleResolver localeResolver() {
//        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
//        // 언어&국가정보가 없는 경우 한국으로 인식하도록 설정
//        localeResolver.setDefaultLocale(Locale.KOREA);
//        return localeResolver;
//    }

    /*
        ReloadableResourceBundleMessageSource
        운영 환경에서도 서버 재배포 없이 리소스가 반영되도록 하는 클래스
    */
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/i18n/messages");
        messageSource.setDefaultEncoding("EUC-KR");
        messageSource.setCacheSeconds(5);
        // 제공하지 않는 언어로 요청이 들어왔을 때 MessageSource에서 사용할 기본 언어정보.
//        Locale.setDefault(Locale.KOREA);
        return messageSource;
    }
}