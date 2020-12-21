package com.radix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@EnableKafka
@SpringBootApplication(scanBasePackages = "com.radix")
public class VendaIngressosApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendaIngressosApplication.class, args);
    }
}
