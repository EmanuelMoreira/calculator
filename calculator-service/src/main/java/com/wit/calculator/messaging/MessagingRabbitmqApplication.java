package com.wit.calculator.messaging;

import com.wit.calculator.DTO.OperationDTO;
import com.wit.calculator.calculatorservice.CalculatorServiceApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessagingRabbitmqApplication {
    private static final Logger log = LoggerFactory.getLogger(MessagingRabbitmqApplication.class);

    private final CalculatorServiceApplication calculatorServiceApplication;

    public MessagingRabbitmqApplication(CalculatorServiceApplication calculatorServiceApplication) {
        this.calculatorServiceApplication = calculatorServiceApplication;
    }

    @RabbitListener(queues = "sendSumMessageQueue")
    public String listenSumMessage(OperationDTO operationDTO) {
        log.info("CalculatorService Receive Request Message: "+operationDTO);
        String result = calculatorServiceApplication.calculate(operationDTO);
        log.info("CalculatorService Send Response Message: "+result);
        return result;
    }

    @RabbitListener(queues = "sendSubMessageQueue")
    public String listenSubMessage(OperationDTO operationDTO) {
        log.info("CalculatorService Receive Request Message: "+operationDTO);
        String result = calculatorServiceApplication.calculate(operationDTO);
        log.info("CalculatorService Send Response Message: "+result);
        return result;
    }

    @RabbitListener(queues = "sendMulMessageQueue")
    public String listenMulMessage(OperationDTO operationDTO) {
        log.info("CalculatorService Receive Request Message: "+operationDTO);
        String result = calculatorServiceApplication.calculate(operationDTO);
        log.info("CalculatorService Send Response Message: "+result);
        return result;
    }

    @RabbitListener(queues = "sendDivMessageQueue")
    public String listenDivMessage(OperationDTO operationDTO) {
        log.info("CalculatorService Receive Request Message: "+operationDTO);
        String result = calculatorServiceApplication.calculate(operationDTO);
        log.info("CalculatorService Send Response Message: "+result);
        return result;
    }
}
