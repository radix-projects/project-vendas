package com.radix.resource.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Log
public class VendaRequest {

    @NotNull(message = "Necessario informar codigo do cliente.")
    private Long cliente;

    @NotNull(message = "Necessario informar quantidade de ingresso.")
    private Integer quantidadeIngressos;

}
