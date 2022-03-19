package com.pxxy.wandering.common.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pxxy.wandering.common.enums.ResultInfoEnum;
import com.pxxy.wandering.common.result.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Resource
    private HttpServletRequest httpServletRequest;

    private static String SWAGGER_RESOURCE_STRING1 = "http://localhost:8888/wandering/swagger-resources";
    private static String SWAGGER_RESOURCE_STRING2 = "http://localhost:8888/wandering/v2/api-docs?group=%E8%AE%BE%E8%AE%A1%E4%B9%8B%E9%81%93";

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 解决 Swagger 静态资源问题
        if(SWAGGER_RESOURCE_STRING1.equals(request.getURI().toString()) || SWAGGER_RESOURCE_STRING2.equals(request.getURI().toString())){
            return body;
        }
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
}
