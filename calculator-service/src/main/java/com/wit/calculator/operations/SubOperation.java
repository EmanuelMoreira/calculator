package com.wit.calculator.operations;

import java.math.BigDecimal;
import java.math.MathContext;

public class SubOperation extends Operation {
    @Override
    public String performOperation(BigDecimal a, BigDecimal b, MathContext mathContext) {
        return a.subtract(b, mathContext).toString();
    }
}
