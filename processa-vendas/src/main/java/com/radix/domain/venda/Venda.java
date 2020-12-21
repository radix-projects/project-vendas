package com.radix.domain.venda;

import lombok.*;
import lombok.extern.java.Log;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log
public class Venda {

    private String id;
    private Long operacao;
    private Long cliente;
    private Integer quantidadeIngressos;
    private BigDecimal valorTotal;
    private String status;

}
