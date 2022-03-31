package com.pxxy.wandering.binlog.controller;

import com.pxxy.wandering.binlog.config.BinLogConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class BinlogController {

    @Resource
    private BinLogConfig binLogConfig;

    @GetMapping("/checkBinLogConfig")
    public void CheckBinLogConfig(){
        log.info("查看BinLog配置信息：{}",binLogConfig.toString());
    }

}
