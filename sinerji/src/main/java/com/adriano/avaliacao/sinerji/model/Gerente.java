package com.adriano.avaliacao.sinerji.model;

import ch.qos.logback.core.spi.ContextAwareImpl;
import com.adriano.avaliacao.sinerji.domain.Competencia;
import com.adriano.avaliacao.sinerji.domain.Contrato;
import com.adriano.avaliacao.sinerji.domain.Funcionario;
import com.adriano.avaliacao.sinerji.domain.enums.TipoCargo;
import com.adriano.avaliacao.sinerji.domain.factory.CargoFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class Gerente extends Contrato {

    public Gerente(Funcionario funcionario, Competencia contratacao){
        super(funcionario,contratacao, TipoCargo.GERENTE);
        setCargo(CargoFactory.createCargo(tipoCargo));
    }
}

