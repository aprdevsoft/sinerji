package com.adriano.avaliacao.sinerji.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {

    private Competencia competencia;
    private float valor;
}
