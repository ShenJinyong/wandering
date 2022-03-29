package com.pxxy.wandering.binlog.model;

import com.baomidou.mybatisplus.generator.fill.Column;
import com.github.shyiko.mysql.binlog.event.EventType;
import com.google.common.collect.Maps;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

import static com.github.shyiko.mysql.binlog.event.EventType.isDelete;
import static com.github.shyiko.mysql.binlog.event.EventType.isWrite;


/**
 * BinLog对象
 * */
@Data
public class BinLogItem implements Serializable {

    private String dbTable;
    private EventType eventType;
    private Long timestamp = null;
    private Long serverId = null;

    private Map<String,Serializable> before = null;
    private Map<String,Serializable> after = null;
    private Map<String, Column> colums = null;

    /**
     * 新增或者删除操作数据格式化
     * */
    public static BinLogItem itemFromInsertOrDeleted(Serializable[] row,Map<String,Column> columnMap,EventType eventType){
        if(null == row || null == columnMap){
            return null;
        }
        if(row.length != columnMap.size()){
            return null;
        }
        // 初始化 Item
        BinLogItem binLogItem = new BinLogItem();
        binLogItem.eventType = eventType;
        binLogItem.colums = columnMap;
        binLogItem.before = Maps.newHashMap();
        binLogItem.after = Maps.newHashMap();

        Map<String, Serializable> beforeOrAfter = Maps.newHashMap();

        columnMap.entrySet().forEach(entry ->{
            String key = entry.getKey();
            Column column = entry.getValue();
//            beforeOrAfter.put(key,row[column.inx]);
        });

        if(isWrite(eventType)){
            binLogItem.after = beforeOrAfter;
        }

        if(isDelete(eventType)){
            binLogItem.before = beforeOrAfter;
        }

        return binLogItem;
    }

    /**
     * 更新操作数据格式化
     * */
    public static BinLogItem itemFromUpdate(Map.Entry<Serializable[],Serializable[]> mapEntry,Map<String,Column> columnMap,EventType eventType){
        if(null == mapEntry || null == columnMap){
            return null;
        }
        // 初始化 Item
        BinLogItem binLogItem = new BinLogItem();
        binLogItem.eventType = eventType;
        binLogItem.colums = columnMap;
        binLogItem.before = Maps.newHashMap();
        binLogItem.after = Maps.newHashMap();

        Map<String,Serializable> before = Maps.newHashMap();
        Map<String,Serializable> after = Maps.newHashMap();

        columnMap.entrySet().forEach(entry -> {
            String key = entry.getKey();
            Column column = entry.getValue();
//            before.put(key,mapEntry.getKey()[column.inx]);
//            after.put(key,mapEntry.getKey()[column.inx]);
        });

        binLogItem.before = before;
        binLogItem.after = after;

        return binLogItem;
    }
}
