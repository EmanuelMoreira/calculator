package com.wit.calculator.operations;

import com.wit.calculator.calculatorservice.CalculatorServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public abstract class Operation {
    protected static final Logger log = LoggerFactory.getLogger(CalculatorServiceApplication.class);

    public String performOperation(String a, String b) {
        BigDecimal numbA;
        BigDecimal numbB;
        try {
            numbA = new BigDecimal(a);
            numbB = new BigDecimal(b);
        } catch (Exception e){
            log.warn("Invalid Number(s): a="+a+"; b="+b+";");
            return "\"Invalid Number(s)\"";
        }

        MathContext mathContext = new MathContext(7, RoundingMode.HALF_UP);
        String result = performOperation(numbA, numbB, mathContext);

        return result;
    }

    public abstract String performOperation(BigDecimal a, BigDecimal b, MathContext mathContext);

    public static Operation getOperation(String operationID){
        switch (operationID){
            case "sum": return new SumOperation();
            case "sub": return new SubOperation();
            case "mul": return new MulOperation();
            case "div": return new DivOperation();
            default: return null;
        }
    }
}
