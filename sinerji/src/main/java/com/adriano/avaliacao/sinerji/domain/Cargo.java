package com.adriano.avaliacao.sinerji.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    protected float bonus;
    protected String nome;
    protected float salario;
}
