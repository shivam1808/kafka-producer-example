package com.practice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    /*
     Create custom topic
    */
    @Bean
    public NewTopic createTopic () {
        return new NewTopic("kafka-practice", 3, (short) 1);
    }
}
