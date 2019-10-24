package com.ming.eurekaclient.impl.package1;

import com.ming.eurekaclient.serivce.IWrite;
import org.springframework.stereotype.Component;

/**
 * Created by panyanming on 2019/10/16.
 */
@Component
public class WriteSame implements IWrite {
    @Override
    public void write() {
        System.out.println("writesame1");
    }
}
