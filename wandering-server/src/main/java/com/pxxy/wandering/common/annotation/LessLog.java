package com.pxxy.wandering.common.annotation;

import com.pxxy.wandering.common.enums.LogType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LessLog {

    LogType type() default LogType.NONE;
}
