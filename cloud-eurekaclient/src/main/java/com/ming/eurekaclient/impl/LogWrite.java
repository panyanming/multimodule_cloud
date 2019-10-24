package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.serivce.IWrite;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/10/16.
 */
@Component
public class LogWrite implements IWrite {
    @Override
    public void write() {
        System.out.println("log write");
    }
}
