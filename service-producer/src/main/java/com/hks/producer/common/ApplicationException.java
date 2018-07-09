package com.hks.producer.common;

import lombok.Data;

@Data
public class ApplicationException extends RuntimeException{

    private int statusCode = 500;
    private String errorCode;
    private String errorMsg;

    public ApplicationException(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ApplicationException(int statusCode, String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.statusCode = statusCode;
    }

    public ApplicationException(CommonExceptionEnum exceptionEnum) {
        this.statusCode = exceptionEnum.getStatusCode();
        this.errorCode = exceptionEnum.getErrorCode();
        this.errorMsg = exceptionEnum.getErrorMsg();
    }

}
