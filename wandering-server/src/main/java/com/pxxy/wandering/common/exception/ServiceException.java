package com.pxxy.wandering.common.exception;

public class ServiceException extends Exception{

    // 默认构造器
    public ServiceException(){

    }

    // 带有详细信息的构造器，信息存储在message中
    public ServiceException(String message){
        super(message);
    }
}
