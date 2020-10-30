package com.wit.calculator.messaging;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.MDC;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MdcLogbackRabbitFilter implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        Message message = (Message) arguments[1];
        String correlationId =(String) message.getMessageProperties().getHeaders().get("correlationId");
        if (correlationId==null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString();
            message.getMessageProperties().setHeader("correlationId", correlationId);
        }

        MDC.put("correlationId", correlationId);

        try {
            return methodInvocation.proceed();
        } finally {
            MDC.remove("correlationId");
        }
    }
}