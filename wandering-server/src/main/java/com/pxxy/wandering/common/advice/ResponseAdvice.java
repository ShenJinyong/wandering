package com.pxxy.wandering.common.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pxxy.wandering.common.enums.ResultInfoEnum;
import com.pxxy.wandering.common.exception.ServiceException;
import com.pxxy.wandering.common.result.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@ControllerAdvice(basePackages = "com.pxxy.wandering.binlog.controller")
public class ResponseAdvice implements ResponseBodyAdvice {

    @Resource
    private HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 返回对象封装
        if(body instanceof HttpResult){
            return body;
        }else if(body instanceof String){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(HttpResult.ok(ResultInfoEnum.SUCCESS,body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else{
            return HttpResult.ok(ResultInfoEnum.SUCCESS,body);
        }
        return body;
    }


    /**
     * 异常日志记录
     */
    private void logErrorRequest(Exception e) {
        log.error("报错API URL:{}", httpServletRequest.getRequestURL().toString());
        log.error("异常:{}", e.getMessage());
    }

    /**
     * 没有发现处理程序异常
     * */
    @ExceptionHandler(NoHandlerFoundException.class)
    public HttpResult handlerNoFoundException(NoHandlerFoundException noHandlerFoundException) {
        logErrorRequest(noHandlerFoundException);
        return HttpResult.ok(ResultInfoEnum.NO_HANDLER_FOUND_EXCEPTION);
    }

    /**
     * 请求的类型不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    private HttpResult httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception) {
        logErrorRequest(exception);
        return HttpResult.ok(ResultInfoEnum.UN_SUPPORTED_METHOD_EXCEPTION);
    }

    /**
     * 缺少请求参数
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    private HttpResult missingServletRequestParameter(MissingServletRequestParameterException exception) {
        logErrorRequest(exception);
        return HttpResult.ok(ResultInfoEnum.MISSING_SERVLET_REQUEST_PARAMETER);
    }

    /**
     * 请求参数格式有误
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    private HttpResult typeMismatch(Exception exception) {
        logErrorRequest(exception);
        return HttpResult.ok(ResultInfoEnum.PARAMETER_FORMAT_EXCEPTION);
    }

    /**
     * 参数未通过@Valid验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    private HttpResult methodArgumentNotValid(MethodArgumentNotValidException exception) {
        logErrorRequest(exception);
        return HttpResult.ok(ResultInfoEnum.INVALID_PARAMETER);
    }

    /**
     * 系统异常
     */
    @ExceptionHandler({HttpClientErrorException.class, IOException.class, Exception.class})
    @ResponseBody
    private HttpResult commonExceptionHandler(Exception exception) {
        logErrorRequest(exception);
        return HttpResult.ok(ResultInfoEnum.SYS_UNKNOWN);
    }

    /**
     * 业务层异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    private HttpResult httpRequestMethodNotSupported(ServiceException exception) {
        logErrorRequest(exception);
        return HttpResult.ok(ResultInfoEnum.SERVICE_EXCEPTION);
    }

}
