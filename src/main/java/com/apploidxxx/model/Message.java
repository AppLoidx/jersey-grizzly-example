package com.apploidxxx.model;

/**
 * @author Arthur Kupriyanov
 */
public class Message {
    public Message(){}
    public Message(String message, int code){

        this.message = message;
        this.code = code;
    }
    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}