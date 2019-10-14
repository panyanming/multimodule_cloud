package com.ming.spi.impl;

import com.ming.spi.spi.LimitPurcharse;

/**
 * Created by panyanming on 2019/10/13.
 */
public class LimitPurchaseImpl2 implements LimitPurcharse {
    @Override
    public boolean checkLimit(int categoryId, int pskuId) {
        return true;
    }
}
