package com.multi.datasource.config.example.config;

import com.multi.datasource.config.example.context.DataSourceContextHolder;
import com.multi.datasource.config.example.routing.DynamicRoutingDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {

    @Bean
    public DataSource dataSource(
            @Qualifier("primaryDataSource") DataSource primaryDataSource,
            @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("primary", primaryDataSource);
        targetDataSources.put("secondary", secondaryDataSource);

        DynamicRoutingDataSource dynamicDataSource = new DynamicRoutingDataSource();
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);

        return dynamicDataSource;
    }
}
