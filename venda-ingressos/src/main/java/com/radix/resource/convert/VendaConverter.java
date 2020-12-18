package com.radix.resource.convert;

import com.radix.domain.venda.Venda;
import com.radix.resource.request.VendaRequest;
import com.radix.resource.response.VendaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VendaConverter {

    private final ModelMapper modelMapper;

    public VendaConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Venda convertDomain(VendaRequest vendaRequest) {
        return modelMapper.map(vendaRequest, Venda.class);
    }

    public VendaResponse convertDto(Venda venda) {
        return modelMapper.map(venda, VendaResponse.class);
    }


}
