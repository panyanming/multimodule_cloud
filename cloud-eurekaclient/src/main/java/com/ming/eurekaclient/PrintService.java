package com.ming.eurekaclient;

import com.ming.eurekaclient.spi.IPrint;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * Created by panyanming on 2019/10/14.
 */
public class PrintService {
    private ServiceLoader<IPrint> serviceLoader;

    private PrintService() {
        serviceLoader = ServiceLoader.load(IPrint.class);
    }

    public static PrintService getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private PrintService printService;
        Singleton() {
            printService = new PrintService();
        }
        public PrintService getInstance() {
            return printService;
        }
    }

    public void print() {
        try {
            Iterator<IPrint> dictionaries = serviceLoader.iterator();
            while (dictionaries.hasNext()) {
                IPrint d = dictionaries.next();
                d.print();
            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace();

        }
    }
}
