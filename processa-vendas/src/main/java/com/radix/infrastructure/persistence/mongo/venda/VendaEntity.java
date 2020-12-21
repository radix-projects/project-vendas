package com.radix.infrastructure.persistence.mongo.venda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Document(value = "vendas")
public class VendaEntity {

    @Id
    private String id;
    private Long operacao;

    @Indexed
    private Long cliente;
    private Integer quantidadeIngressos;
    private BigDecimal valorTotal;

    @Indexed
    private String status;
}
