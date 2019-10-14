package com.ming.spi;

import com.ming.spi.spi.LimitPurcharse;

/**
 * Created by panyanming on 2019/10/13.
 */
public class LimitPurchaseImpl1 implements LimitPurcharse {
    @Override
    public boolean checkLimit(int categoryId, int pskuId) {
        return true;
    }
}
