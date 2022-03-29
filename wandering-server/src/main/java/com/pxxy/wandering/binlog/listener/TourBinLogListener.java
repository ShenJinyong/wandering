package com.pxxy.wandering.binlog.listener;

import com.pxxy.wandering.binlog.config.BinLogConfig;
import com.pxxy.wandering.binlog.util.BinLogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TourBinLogListener implements CommandLineRunner {

    @Autowired
    private BinLogConfig binLogConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化配置信息：{}",binLogConfig.toString());

        // 初始化监听器
        MySQLBinLogListener mySQLBinLogListener = new MySQLBinLogListener(binLogConfig);

        // 获取table集合
    }
}
