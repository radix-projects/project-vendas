package com.radix.domain.venda;


import com.radix.infrastructure.messaging.kafka.Message;
import com.radix.infrastructure.persistence.mongo.venda.VendaEntity;
import com.radix.infrastructure.persistence.mongo.venda.VendaEntityRepository;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log
@Service
public class VendaService {

    private static final String TOPIC_NOVA_VENDA = "TOPIC_NOVA_VENDA";

    private final VendaConverter vendaConverter;
    private final VendaEntityRepository vendaEntityRepository;

    public VendaService(VendaConverter vendaConverter, VendaEntityRepository vendaEntityRepository) {
        this.vendaConverter = vendaConverter;
        this.vendaEntityRepository = vendaEntityRepository;
    }

    @KafkaListener(topics = TOPIC_NOVA_VENDA)
    public void processarVendas(Message<Venda> message) {

        Venda venda = message.getPayLoad();
        log.info(String.format("processando vendas  %s", venda));
        VendaEntity vendaEntityPersistida = vendaEntityRepository.save(vendaConverter.toModel(venda));
        log.info(String.format("venda cadastrada  %s", vendaEntityPersistida));
    }
}
