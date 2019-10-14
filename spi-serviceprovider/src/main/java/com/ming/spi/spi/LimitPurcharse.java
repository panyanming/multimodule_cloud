package com.ming.spi.spi;

/**
 * Created by panyanming on 2019/10/13.
 */
public interface LimitPurcharse {
    boolean checkLimit(int categoryId,int pskuId);
}
