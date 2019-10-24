package com.ming.eurekaclient;

import com.ming.eurekaclient.impl.package1.WriteSame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by panyanming on 2019/10/16.
 */
@Configuration
public class AutoConfig {

    @Bean
    public WriteSame writeSame1() {
        return new WriteSame();
    }
}
