package com.pxxy.wandering.binlog.listener;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.*;
import com.pxxy.wandering.binlog.config.BinLogConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 数据库监听器
 * */
@Slf4j
@Component
@Order(value = 1)
public class MysqlBinlogListener implements CommandLineRunner {


    @Resource
    private BinLogConfig binLogConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("查看BinLog配置信息：{}",binLogConfig.toString());
        BinaryLogClient binaryLogClient = new BinaryLogClient(binLogConfig.getHost(), binLogConfig.getPort(), binLogConfig.getUsername(), binLogConfig.getPassword());
        binaryLogClient.setServerId(2);
        binaryLogClient.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof TableMapEventData) {
                System.out.println("Table:");
                TableMapEventData tableMapEventData = (TableMapEventData) data;
                System.out.println(tableMapEventData.getTableId()+": ["+tableMapEventData.getDatabase() + "-" + tableMapEventData.getTable()+"]");
            }
            if (data instanceof UpdateRowsEventData) {
                System.out.println("Update:");
                System.out.println(data.toString());
            } else if (data instanceof WriteRowsEventData) {
                System.out.println("Insert:");
                System.out.println(data.toString());
            } else if (data instanceof DeleteRowsEventData) {
                System.out.println("Delete:");
                System.out.println(data.toString());
            }
        });
        binaryLogClient.connect();
    }
}
