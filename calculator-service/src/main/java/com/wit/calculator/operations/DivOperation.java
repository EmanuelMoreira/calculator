package com.wit.calculator.operations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;

public class DivOperation extends Operation {
    @Override
    public String performOperation(BigDecimal a, BigDecimal b, MathContext mathContext) {
        if (b.compareTo(new BigDecimal(0))==0){
            log.warn("Invalid Division: b="+b+";");
            return "\"Invalid Division\"";
        }

        return a.divide(b, mathContext).toString();
    }
}
