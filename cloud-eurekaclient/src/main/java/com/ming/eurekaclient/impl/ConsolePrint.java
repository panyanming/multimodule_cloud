package com.ming.eurekaclient.impl;

import com.ming.eurekaclient.spi.IPrint;

/**
 * Created by panyanming on 2019/10/14.
 */
public class ConsolePrint implements IPrint {
    @Override
    public void print() {
        System.out.println("console print");
    }
}
