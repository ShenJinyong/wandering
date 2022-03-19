package com.pxxy.wandering.common.enums;

import com.pxxy.wandering.common.constant.ResultMessageConstants;
import com.pxxy.wandering.common.service.ResultInfoService;

public enum ResultInfoEnum implements ResultInfoService {

    SUCCESS(Boolean.TRUE,"200", ResultMessageConstants.SUCCESS),
    // 异常处理
    NO_HANDLER_FOUND_EXCEPTION(Boolean.FALSE,"404",ResultMessageConstants.NO_HANDLER_FOUND_EXCEPTION),
    UN_SUPPORTED_METHOD_EXCEPTION(Boolean.FALSE,"405",ResultMessageConstants.UN_SUPPORTED_METHOD_EXCEPTION),
    MISSING_SERVLET_REQUEST_PARAMETER(Boolean.FALSE,"400",ResultMessageConstants.MISSING_SERVLET_REQUEST_PARAMETER),
    PARAMETER_FORMAT_EXCEPTION(Boolean.FALSE,"401",ResultMessageConstants.PARAMETER_FORMAT_EXCEPTION),
    INVALID_PARAMETER(Boolean.FALSE,"402",ResultMessageConstants.INVALID_PARAMETER),
    SERVICE_EXCEPTION(Boolean.FALSE,"403",ResultMessageConstants.SERVICE_EXCEPTION),
    SYS_UNKNOWN(Boolean.FALSE,"500",ResultMessageConstants.SYS_UNKNOWN)
    ;

    private boolean success;
    private String code;
    private String message;

    ResultInfoEnum(Boolean success,String code,String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
