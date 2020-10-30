package com.wit.calculator.calculatorservice;

import com.wit.calculator.DTO.OperationDTO;
import com.wit.calculator.operations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(CalculatorServiceApplication.class);

	public String calculate(OperationDTO operationDTO) {
		String result;
		Operation operation = Operation.getOperation(operationDTO.getOperation());
		if (operation != null) {
			result = operation.performOperation(operationDTO.getA(), operationDTO.getB());
		} else {
			result = "\"Invalid Operation\"";
		}

		log.info("Result from Operation: "+result);
		return result;
	}
}
