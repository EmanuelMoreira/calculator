package com.wit.calculator.rest;

import com.wit.calculator.DTO.OperationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class SendMessage {
    private static final Logger log = LoggerFactory.getLogger(SendMessage.class);

    private final RabbitTemplate rabbitTemplate;

    SendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    String sendMessage(OperationDTO operationDTO){
        setRabbitTemplate();

        String queue = getQueue(operationDTO);
        if (queue == null) return "\"Invalid Operation\"";

        log.info("Rest Send Request Message: "+operationDTO);
        String result = rabbitTemplate.convertSendAndReceiveAsType(queue,
                operationDTO,
                new ParameterizedTypeReference<String>() {});
        log.info("Rest Receive Response Message: "+result);
        return result;
    }

    private String getQueue(OperationDTO operationDTO) {
        String queue;
        switch (operationDTO.getOperation()) {
            case "sum":
                queue = "sendSumMessageQueue";
                break;
            case "sub":
                queue = "sendSubMessageQueue";
                break;
            case "mul":
                queue = "sendMulMessageQueue";
                break;
            case "div":
                queue = "sendDivMessageQueue";
                break;
            default:
                return null;
        }
        return queue;
    }

    private void setRabbitTemplate() {
        rabbitTemplate.setBeforePublishPostProcessors(message -> {
            String correlationId = MDC.get("correlationId");
            if (correlationId!=null && !correlationId.isEmpty()) {
                message.getMessageProperties().setHeader("correlationId", correlationId);
            }
            return message;
        });
    }
}
