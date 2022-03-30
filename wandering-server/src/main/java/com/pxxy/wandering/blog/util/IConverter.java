package com.pxxy.wandering.blog.util;

public interface IConverter<T,E> {
    /**
     * VO 转换函数
     * */
    E convertToVO(T t);
}
