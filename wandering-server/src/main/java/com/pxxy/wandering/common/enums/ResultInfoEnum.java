package com.pxxy.wandering.common.enums;

import com.pxxy.wandering.common.constant.ResultMessageConstants;
import com.pxxy.wandering.common.service.ResultInfoService;

public enum ResultInfoEnum implements ResultInfoService {

    SUCCESS(Boolean.TRUE,"200", ResultMessageConstants.SUCCESS);

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
