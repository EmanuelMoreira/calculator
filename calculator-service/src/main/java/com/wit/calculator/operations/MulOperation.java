package com.wit.calculator.operations;

import java.math.BigDecimal;
import java.math.MathContext;

public class MulOperation extends Operation {
    @Override
    public String performOperation(BigDecimal a, BigDecimal b, MathContext mathContext) {
        return a.multiply(b, mathContext).toString();
    }
}
