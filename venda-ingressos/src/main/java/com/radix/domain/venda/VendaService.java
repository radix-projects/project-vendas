package com.radix.domain.venda;

import com.radix.infrastructure.messaging.kafka.CorrelationId;
import com.radix.infrastructure.messaging.kafka.KafkaDispatcher;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Log
@Service
public class VendaService {

    private static final String TOPIC_NOVA_VENDA = "TOPIC_NOVA_VENDA";

    private final KafkaDispatcher kafkaDispatcher;

    public VendaService(KafkaDispatcher kafkaDispatcher) {
        this.kafkaDispatcher = kafkaDispatcher;
    }

    public Venda gerar(Venda venda) {

        log.info("Gerando nova venda");
        venda.setId(new Random().nextLong());
        venda.setStatus("EM_PROCESSO");
        venda.setOperacao(new Random().nextLong());
        venda.setValorTotal(new BigDecimal(venda.getQuantidadeIngressos() * 150));

        log.info("Disponibilizando nova venda.");
        kafkaDispatcher.send(TOPIC_NOVA_VENDA, venda.getId().toString(), new CorrelationId(VendaService.class.getSimpleName()), venda);

        return venda;
    }
}
