package com.hks.app.entity;

import java.io.Serializable;

/**
 * @author Huangkunsong
 */
public class StompMessage implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
