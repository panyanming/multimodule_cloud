package com.ming.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by panyanming on 2019/9/20.
 */
@Configuration
public class AppConifg {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
