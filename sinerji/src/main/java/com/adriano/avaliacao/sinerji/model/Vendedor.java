package com.adriano.avaliacao.sinerji.model;

import com.adriano.avaliacao.sinerji.domain.*;
import com.adriano.avaliacao.sinerji.domain.enums.TipoCargo;
import com.adriano.avaliacao.sinerji.domain.factory.CargoFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor extends ContratoBeneficio {

    public List<Venda> vendas;

    public Vendedor(Funcionario funcionario, Competencia contratacao){
        super(funcionario,contratacao, TipoCargo.VENDEDOR);
        setCargo(CargoFactory.createCargo(tipoCargo));
        setBeneficio(0.3f);
    }

    public Venda getVenda(Competencia competencia){
        for (Venda venda : vendas){
            if(venda.getCompetencia().equivalente(competencia))
                return venda;
        }

        return null;
    }

    @Override
    public float calcularBeneficio(Competencia competencia) {
        return getVenda(competencia).getValor() * beneficio;
    }
}
