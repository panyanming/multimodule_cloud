package com.ming.spi;

import com.ming.spi.spi.LimitPurcharse;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * Created by panyanming on 2019/10/13.
 */
public class LimitPurcharseService {

    private static LimitPurcharseService service;
    private ServiceLoader<LimitPurcharse> loader;

    public static LimitPurcharseService getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private LimitPurcharseService() {
        loader = ServiceLoader.load(LimitPurcharse.class);
    }

    private enum Singleton {
        INSTANCE;

        private LimitPurcharseService service;

        Singleton() {
            service = new LimitPurcharseService();
        }

        public LimitPurcharseService getInstance() {
            return service;
        }
    }


    public boolean checkLimit(int categoryId, int pskuId) {
        boolean result = false;
        try {
            Iterator<LimitPurcharse> dictionaries = loader.iterator();
            while (dictionaries.hasNext()) {

                System.out.printf("发现了spi实现");
                LimitPurcharse d = dictionaries.next();
                result = d.checkLimit(categoryId, pskuId);
            }
        } catch (ServiceConfigurationError serviceError) {
            result = false;
            serviceError.printStackTrace();

        }
        return result;
    }

}
