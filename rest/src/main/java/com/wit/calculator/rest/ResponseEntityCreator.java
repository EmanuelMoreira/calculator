package com.wit.calculator.rest;

import com.wit.calculator.DTO.OperationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityCreator {
    private static Logger log = LoggerFactory.getLogger(ResponseEntityCreator.class);

    private final SendMessage sendMessage;
    ResponseEntityCreator(SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    ResponseEntity getResponseEntity(String a, String b, String operation) {
        // Request
        log.info("Rest Receive Request: /"+operation+"?a="+a+"&b="+b);
        OperationDTO operationDTO = new OperationDTO();
        operationDTO.setOperation(operation);
        operationDTO.setA(a);
        operationDTO.setB(b);

        String result = sendMessage.sendMessage(operationDTO);

        // Response
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity responseEntity = ResponseEntity.ok().headers(responseHeaders).body("{\"result\":" + result + "}");
        log.info("Rest Send Response: "+responseEntity);

        return responseEntity;
    }
}
