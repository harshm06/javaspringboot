package com.example.test.services;

import com.example.test.config.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

@Service
public class DbConfigService {
    @Autowired
    private DbConfig dbConfig;


    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dbConfig.getUrl());
        dataSourceBuilder.username(dbConfig.getUsername());
        dataSourceBuilder.password(dbConfig.getPassword());
        return dataSourceBuilder.build();
    }
}
