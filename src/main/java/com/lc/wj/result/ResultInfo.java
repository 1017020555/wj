package com.lc.wj.result;

public class ResultInfo<T> {

    private boolean success = true;
    private String message;
    private T value;

    public ResultInfo() {
    }

    public ResultInfo(boolean success) {
        this.success = success;
    }

    public ResultInfo(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultInfo(boolean success, String message, T value) {
        super();
        this.success = success;
        this.message = message;
        this.value = value;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
