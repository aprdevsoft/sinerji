package com.adriano.avaliacao.sinerji.service;

import com.adriano.avaliacao.sinerji.domain.*;
import com.adriano.avaliacao.sinerji.domain.enums.TipoCargo;
import com.adriano.avaliacao.sinerji.domain.factory.CargoFactory;
import com.adriano.avaliacao.sinerji.model.Gerente;
import com.adriano.avaliacao.sinerji.model.Secretario;
import com.adriano.avaliacao.sinerji.model.Vendedor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class SinerjiService {

    public List<Cargo> cargos(){
        var contratos =  new ArrayList<Cargo>();

        contratos.add(CargoFactory.createCargo(TipoCargo.SECRETARIO));
        contratos.add(CargoFactory.createCargo(TipoCargo.VENDEDOR));
        contratos.add(CargoFactory.createCargo(TipoCargo.GERENTE));

        return contratos;
    }

    private List<Venda> vendasAna(){
        var vendas =  new ArrayList<Venda>();

        vendas.add(new Venda(new Competencia("12/2021"), 5200));
        vendas.add(new Venda(new Competencia("01/2022"), 4000));
        vendas.add(new Venda(new Competencia("02/2022"), 4200));
        vendas.add(new Venda(new Competencia("03/2022"), 5850));
        vendas.add(new Venda(new Competencia("04/2022"), 7000));

        return vendas;
    }

    private List<Venda> vendasJoao(){
        var vendas =  new ArrayList<Venda>();

        vendas.add(new Venda(new Competencia("12/2021"), 3400));
        vendas.add(new Venda(new Competencia("01/2022"), 7700));
        vendas.add(new Venda(new Competencia("02/2022"), 5000));
        vendas.add(new Venda(new Competencia("03/2022"), 5900));
        vendas.add(new Venda(new Competencia("04/2022"), 6500));

        return vendas;
    }
    public List<Venda> vendas(){
        var vendas =  new ArrayList<Venda>();

        vendas.addAll(vendasAna());
        vendas.addAll(vendasJoao());

        return vendas;
    }

    public List<Venda> vendas(Competencia competencia){
        var vendas = new ArrayList<Venda>();

        for (Venda venda : vendas()){
            if(venda.getCompetencia().equivalente(competencia))
                vendas.add(venda);
        }

        return vendas;
    }

    public List<Contrato> funcionarios(){
        var contratos =  new ArrayList<Contrato>();

        var jor = new Secretario(
                new Funcionario("Jorge Carvalho"),
                new Competencia("01/2018")
        );
        var mar = new Secretario(
                new Funcionario("Maria Souza"),
                new Competencia("12/2015")
        );
        var ana = new Vendedor(
                new Funcionario("Ana Silva"),
                new Competencia("12/2021")
        );
        ana.setVendas(vendasAna());

        var joa = new Vendedor(
                new Funcionario("João Mendes"),
                new Competencia("12/2021")
        );
        joa.setVendas(vendasJoao());

        var jul = new Gerente(
                new Funcionario("Juliana Alves"),
                new Competencia("07/2017")
        );
        var ben = new Gerente(
                new Funcionario("Bento Albino"),
                new Competencia("03/2014")
        );

        contratos.add(jor);
        contratos.add(mar);
        contratos.add(ana);
        contratos.add(joa);
        contratos.add(jul);
        contratos.add(ben);

        return contratos;
    }

    public float valorTotalPago(List<Contrato> funcionarios, Competencia competencia){

        float total = 0;

        for (Contrato funcionario : funcionarios) {
            total += funcionario.calcularGastoTotal(competencia);
        }

        return total;
    }

    public float valorTotalSalario(List<Contrato> funcionarios, Competencia competencia){
        float total = 0;

        for (Contrato funcionario : funcionarios) {
            total += funcionario.calcularSalario(competencia);
        }

        return total;
    }

    public float valorTotalBeneficio(List<ContratoBeneficio> cargos, Competencia competencia){
        float total = 0;

        for (ContratoBeneficio cargo : cargos) {
            total += cargo.calcularBeneficio(competencia);
        }

        return total;
    }

    public Funcionario maiorValorTotal(List<Contrato> funcionarios, Competencia competencia){
        float maior = 0;
        Funcionario retorno = null;

        for (Contrato funcionario : funcionarios) {
            float total = funcionario.calcularGastoTotal(competencia);

            if(total > maior){
                maior = total;
                retorno = funcionario.getFuncionario();
            }
        }

        return retorno;
    }

    public Funcionario maiorValorBeneficio(List<ContratoBeneficio> cargos, Competencia competencia){
        float maior = 0;
        Funcionario retorno = null;

        for (ContratoBeneficio cargo : cargos) {
            float total =  cargo.calcularBeneficio(competencia);

            if(total > maior){
                maior = total;
                retorno = cargo.getFuncionario();
            }
        }

        return retorno;
    }

    public Funcionario maiorValorVendas(List<Vendedor> vendedores, Competencia competencia){
        float maior = 0;
        Funcionario retorno = null;

        for (Vendedor vendedor : vendedores) {
            Venda venda =  vendedor.getVenda(competencia);

            if(venda.getValor() > maior){
                maior = venda.getValor();
                retorno = vendedor.getFuncionario();
            }
        }

        return retorno;
    }
}
