package com.pxxy.wandering.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pxxy.wandering.common.annotation.LessLog;
import com.pxxy.wandering.common.enums.LogType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class RequestLogAspect {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Around("execution(* com.pxxy.wandering.*.controller..*.*(..))")
    public Object around(final ProceedingJoinPoint joinPoint) throws Throwable{

        boolean urlLogRequired = Boolean.TRUE;
        boolean requestLogRequired = Boolean.TRUE;
        boolean responseLogRequired = Boolean.TRUE;

        Class<?> clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        Method method = clazz.getMethod(methodName, parameterTypes);

        if(method.isAnnotationPresent(LessLog.class)){
            // 减少日志注释
            LessLog lessLog = method.getAnnotation(LessLog.class);
            LogType logType = lessLog.type();
            switch (logType){
                case  URL:
                    urlLogRequired = Boolean.FALSE;
                    break;
                case REQUEST:
                    requestLogRequired = Boolean.FALSE;
                    break;
                case RESPONSE:
                    responseLogRequired = Boolean.FALSE;
                case ALL:
                    urlLogRequired = Boolean.FALSE;
                    requestLogRequired = Boolean.FALSE;
                    responseLogRequired = Boolean.FALSE;
                    break;
                default:
            }
        }

        // url日志
        if(urlLogRequired){
            log.info("请求url:{}",httpServletRequest.getRequestURI());
        }

        // 请求日志
        ObjectMapper objectMapper = new ObjectMapper();
        if(requestLogRequired){
            log.info("请求参数：{}",objectMapper.writeValueAsString(joinPoint.getArgs()));
        }

        // 响应日志
        Object proceed = joinPoint.proceed();
        if(responseLogRequired){
            log.info("请求返回：{}",objectMapper.writeValueAsString(proceed));
        }

        return proceed;
    }
}
