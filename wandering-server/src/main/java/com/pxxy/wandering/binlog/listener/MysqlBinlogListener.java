package com.pxxy.wandering.binlog.listener;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import com.pxxy.wandering.binlog.config.BinLogConfig;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 数据库监听器
 * */
@Slf4j
public class MysqlBinlogListener implements BinaryLogClient.EventListener {

    /**
     * 监听初始化
     * */
    public MysqlBinlogListener(BinLogConfig binLogConfig){
        BinaryLogClient binaryLogClient = new BinaryLogClient(binLogConfig.getHost(), binLogConfig.getPort(), binLogConfig.getUsername(), binLogConfig.getPassword());
        EventDeserializer eventDeserializer = new EventDeserializer();
        binaryLogClient.setEventDeserializer(eventDeserializer);
        binaryLogClient.setServerId(100);
    }

    /**
     * 监听处理
     * */
    @Override
    public void onEvent(Event event) {
        log.info("监听Binlog事件：{}",event);
    }
}
