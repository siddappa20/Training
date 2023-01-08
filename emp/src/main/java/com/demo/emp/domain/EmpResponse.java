package com.demo.emp.domain;

import java.io.Serializable;

public class EmpResponse implements Serializable {

    private static final long serialVersionUID = 4523523451L;

    private Object empRes;
    private String message;

    public EmpResponse() {
    }

    public EmpResponse(Object empRes, String message) {
        super();
        this.empRes = empRes;
        this.message = message;
    }

    public Object getEmpRes() {
        return empRes;
    }

    public void setEmpRes(Object empRes) {
        this.empRes = empRes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
