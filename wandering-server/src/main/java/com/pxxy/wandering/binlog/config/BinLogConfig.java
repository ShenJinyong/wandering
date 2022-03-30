package com.pxxy.wandering.binlog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("binlog")
public class BinLogConfig {

    private String host;
    private int port;
    private String username;
    private String password;
    private String db;
    private String table;
    private int consumerThreads;
    private int queueSleep;
}
