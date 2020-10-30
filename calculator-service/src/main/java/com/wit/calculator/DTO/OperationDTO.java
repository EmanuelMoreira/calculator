package com.wit.calculator.DTO;

import java.io.Serializable;

public class OperationDTO implements Serializable {
    private static final long serialversionUID = 129348938L;

    private String operation;
    private String a;
    private String b;

    public OperationDTO() { }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "{" +
                "operation='" + operation + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
