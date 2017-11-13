package com.senlaCourse.commonData;

import java.io.Serializable;

public class Request implements Serializable {
    private final static long serialVersionUID = 1L;
    private String nameMethod;
    private Object[] parameters;

    public Request(String nameMethod, Object[] parameters) {
        this.nameMethod = nameMethod;
        this.parameters = parameters;
    }

    public String getNameMethod() {
        return nameMethod;
    }

    public Object[] getParameters() {
        return parameters;
    }
}
