package com.practice.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) throws InterruptedException, ExecutionException {
        CompletableFuture<SendResult<String, Object>> future = template.send("kafka-practice", message);
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error sending message to Kafka topic: " + ex.getMessage());
            } else {
                System.out.println("Message sent to Kafka topic successfully : " + message);
                System.out.println("Partition : " + result.getRecordMetadata().partition());
                System.out.println("Offset : " + result.getRecordMetadata().offset());
            }
        });
    }

}
