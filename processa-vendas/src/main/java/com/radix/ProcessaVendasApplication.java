package com.radix;

import com.radix.infrastructure.messaging.kafka.config.consumer.KafkaConsumerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@Import(KafkaConsumerConfig.class)
@EnableKafka
@EnableMongoRepositories(basePackages = {"com.radix.infrastructure.persistence.mongo"})
@SpringBootApplication(scanBasePackages = "com.radix")
public class ProcessaVendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProcessaVendasApplication.class, args);
    }
}
