package com.radix.domain.venda;

import com.radix.infrastructure.persistence.mongo.venda.VendaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VendaConverter {

    private final ModelMapper modalMapper;

    public VendaConverter(ModelMapper modalMapper) {
        this.modalMapper = modalMapper;
    }

    public VendaEntity toModel(Venda venda) {
        return modalMapper.map(venda, VendaEntity.class);
    }

    public Venda toDomain(VendaEntity venda) {
        return modalMapper.map(venda, Venda.class);
    }

}
