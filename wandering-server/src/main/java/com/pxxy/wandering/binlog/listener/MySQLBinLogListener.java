package com.pxxy.wandering.binlog.listener;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import com.pxxy.wandering.binlog.config.BinLogConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySQLBinLogListener implements BinaryLogClient.EventListener {

    public MySQLBinLogListener(BinLogConfig binLogConfig){
        BinaryLogClient binaryLogClient = new BinaryLogClient(binLogConfig.getHost(), binLogConfig.getPort(), binLogConfig.getUsername(), binLogConfig.getPassword());
        EventDeserializer eventDeserializer = new EventDeserializer();
        binaryLogClient.setEventDeserializer(eventDeserializer);
    }

    @Override
    public void onEvent(Event event) {
      log.info("事件：{}",event);
    }
}
