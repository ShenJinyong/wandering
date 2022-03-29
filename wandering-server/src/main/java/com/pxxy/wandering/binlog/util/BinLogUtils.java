package com.pxxy.wandering.binlog.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 监听工具
 * */
@Slf4j
@Component
public class BinLogUtils {

    private static BinLogUtils binLogUtils;

    @PostConstruct
    public void init(){
        binLogUtils = this;
    }

    /**
     * 拼接dbTable
     * */
    public static String getDbTable(String db,String table){
        return db + "_" + table;
    }

}
