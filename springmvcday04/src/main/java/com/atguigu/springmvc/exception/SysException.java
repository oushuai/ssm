package com.atguigu.springmvc.exception;

/**
 * @author ouyangjie
 * @createTime 2020-03-06 16:40
 */
public class SysException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public SysException(String message) {
        this.message = message;
    }
}
