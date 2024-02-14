package com.adriano.avaliacao.sinerji.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Competencia {

    private short ano;
    private short mes;


    public Competencia(String mesAno){
        String[] split = mesAno.split("/");
        mes = Short.parseShort(split[0]);
        ano = Short.parseShort(split[1]);
    }

    public boolean equivalente(Competencia competencia){
        return ano == competencia.getAno() && mes == competencia.getMes();
    }

    public short calcularAnos(Competencia competencia){
        return (short) java.time.temporal.ChronoUnit.YEARS.between( toLocalDate() , competencia.toLocalDate() );
    }

    public LocalDate toLocalDate(){
        return LocalDate.of( ano , mes , 1 ) ;
    }
}
