package com.hks.producer.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultWrap<T> implements Serializable{
    private String code = "200";
    private String message = "Success";
    private T data;
}
