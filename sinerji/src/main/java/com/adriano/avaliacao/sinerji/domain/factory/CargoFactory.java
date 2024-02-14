package com.adriano.avaliacao.sinerji.domain.factory;

import com.adriano.avaliacao.sinerji.domain.Cargo;
import com.adriano.avaliacao.sinerji.domain.enums.TipoCargo;

public class CargoFactory {

    private CargoFactory(){}

    public static Cargo createCargo(TipoCargo tipoCargo){
        switch (tipoCargo){
            case TipoCargo.SECRETARIO -> { return createSecretario(); }
            case TipoCargo.VENDEDOR   -> { return createVendedor(); }
            case TipoCargo.GERENTE    -> { return createGerente(); }
        }
        return null;
    }

    private static Cargo createVendedor(){
        var cargo = new Cargo();
        cargo.setSalario(12000);
        cargo.setBonus(1800);
        cargo.setNome("Vendedor");
        return cargo;
    }

    private static Cargo createSecretario(){
        var cargo = new Cargo();
        cargo.setSalario(7000);
        cargo.setBonus(1000);
        cargo.setNome("Secretário");
        return cargo;
    }

    private static Cargo createGerente(){
        var cargo = new Cargo();
        cargo.setSalario(20000);
        cargo.setBonus(3000);
        cargo.setNome("Gerente");
        return cargo;
    }
}
