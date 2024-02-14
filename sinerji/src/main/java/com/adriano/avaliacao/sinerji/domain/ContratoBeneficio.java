package com.adriano.avaliacao.sinerji.domain;

import com.adriano.avaliacao.sinerji.domain.enums.TipoCargo;
import com.adriano.avaliacao.sinerji.model.Secretario;
import com.adriano.avaliacao.sinerji.model.Vendedor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContratoBeneficio extends Contrato implements Beneficio{

    protected float beneficio;

    public ContratoBeneficio(Funcionario funcionario, Competencia contratacao, TipoCargo tipoCargo){
        super(funcionario, contratacao, tipoCargo);
    }

    @Override
    public float calcularGastoTotal(Competencia competencia){
        return calcularSalario(competencia) + calcularBeneficio(competencia);
    }
}
