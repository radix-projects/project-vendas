package com.radix.domain.venda;

import com.radix.infrastructure.messaging.kafka.Message;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log
@Service
public class VendaService {

    private static final String TOPIC_NOVA_VENDA = "TOPIC_NOVA_VENDA";

    @KafkaListener(topics = TOPIC_NOVA_VENDA)
    public void processarVendas(Message message) {

        log.info(String.format("processando venda %s", message));

    }
}
