package com.radix.resource;

import com.radix.domain.venda.Venda;
import com.radix.domain.venda.VendaService;
import com.radix.resource.convert.VendaConverter;
import com.radix.resource.request.VendaRequest;
import com.radix.resource.response.VendaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class VendaResource {

    private final VendaService vendaService;
    private final VendaConverter vendaConverter;

    public VendaResource(VendaService vendaService, VendaConverter vendaConverter) {
        this.vendaService = vendaService;
        this.vendaConverter = vendaConverter;
    }

    @PostMapping
    public ResponseEntity<VendaResponse> gerar(@Valid @RequestBody VendaRequest vendaRequest, HttpServletResponse response) {
        Venda venda = vendaService.gerar(vendaConverter.convertDomain(vendaRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaConverter.convertDto(venda));
    }


}
