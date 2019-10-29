package com.ming.eurekaclient.serivce;

/**
 * Created by panyanming on 2019/10/29.
 */
public interface IFactorySerivce extends ISPI<Integer> {

    default void excecute(int level) {
        facotryTest();
    }
    void facotryTest();
}
