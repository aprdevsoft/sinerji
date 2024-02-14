package com.adriano.avaliacao.sinerji.model;

import com.adriano.avaliacao.sinerji.domain.Competencia;
import com.adriano.avaliacao.sinerji.domain.ContratoBeneficio;
import com.adriano.avaliacao.sinerji.domain.Funcionario;
import com.adriano.avaliacao.sinerji.domain.enums.TipoCargo;
import com.adriano.avaliacao.sinerji.domain.factory.CargoFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Secretario extends ContratoBeneficio {

    public Secretario(Funcionario funcionario, Competencia contratacao){
        super(funcionario,contratacao, TipoCargo.SECRETARIO);
        setCargo(CargoFactory.createCargo(tipoCargo));
        setBeneficio(0.2f);
    }

    @Override
    public float calcularBeneficio(Competencia competencia) {
        return calcularSalario(competencia) * beneficio;
    }
}
