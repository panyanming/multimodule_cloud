package com.ming.eurekaclient.config;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by panyanming on 2019/11/26.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
        return dataBaseType;
    }
}

