package com.adriano.avaliacao.sinerji.domain;

import com.adriano.avaliacao.sinerji.domain.enums.TipoCargo;
import com.adriano.avaliacao.sinerji.model.Gerente;
import com.adriano.avaliacao.sinerji.model.Secretario;
import com.adriano.avaliacao.sinerji.model.Vendedor;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "tipoCargo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Secretario.class, name = "SECRETARIO"),
        @JsonSubTypes.Type(value = Vendedor.class, name = "VENDEDOR"),
        @JsonSubTypes.Type(value = Gerente.class, name = "GERENTE"),
})
public abstract class Contrato {

    protected Cargo cargo;
    protected Competencia contratacao;
    protected Funcionario funcionario;
    protected TipoCargo tipoCargo;

    public Contrato(Funcionario funcionario, Competencia contratacao, TipoCargo tipoCargo){
        this.funcionario = funcionario;
        this.contratacao = contratacao;
        this.tipoCargo = tipoCargo;
    }

    public float calcularSalario(Competencia competencia){
        return cargo.getSalario() + cargo.getBonus() * anosServico(competencia);
    }

    public float calcularGastoTotal(Competencia competencia){
        return calcularSalario(competencia);
    }

    public short anosServico(Competencia competencia){
        return contratacao.calcularAnos(competencia);
    }
}
