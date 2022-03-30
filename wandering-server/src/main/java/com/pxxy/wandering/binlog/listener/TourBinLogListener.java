package com.pxxy.wandering.binlog.listener;

import com.pxxy.wandering.binlog.config.BinLogConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
@Order(value = 1)
public class TourBinLogListener implements CommandLineRunner {

    @Resource
    private BinLogConfig binLogConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化BinLog配置信息：{}",binLogConfig.toString());
        // 初始化监听器
        MysqlBinlogListener mysqlBinlogListener = new MysqlBinlogListener(binLogConfig);
        // 获取table集合
        log.info("注册监听信息，注册DB:{},注册表：{}",binLogConfig.getDb(),binLogConfig.getTable());
    }

}
