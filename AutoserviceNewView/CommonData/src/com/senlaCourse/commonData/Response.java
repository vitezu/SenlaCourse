package com.senlaCourse.commonData;

import java.io.Serializable;

public class Response implements Serializable {
    private final static long serialVersionUID = 1L;
    private Class<?> type;
    private Boolean isSuccess;
    private Object result;

    public void setType(Class<?> type) {
        this.type = type;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public Class<?> getType() {
        return type;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }
}
