package com.radix.resource.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log
public class VendaResponseld {

    private Long operacao;
    private Long cliente;
    private Integer quantidadeIngressos;
    private BigDecimal valorTotal;
    private String status;

}
