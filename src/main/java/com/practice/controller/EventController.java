package com.practice.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.service.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage (String message) throws InterruptedException, ExecutionException {
        kafkaMessagePublisher.sendMessageToTopic(message);
        return ResponseEntity.ok("Message Publish Successfully");
    }
}
