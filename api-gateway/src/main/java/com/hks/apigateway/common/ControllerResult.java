package com.hks.apigateway.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ControllerResult<T> implements Serializable{
    private String errorCode = "200";
    private String errorMsg = "Success";
    private T result;
}
