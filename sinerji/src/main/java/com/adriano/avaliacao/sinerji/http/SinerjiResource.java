package com.adriano.avaliacao.sinerji.http;

import com.adriano.avaliacao.sinerji.domain.*;
import com.adriano.avaliacao.sinerji.model.Vendedor;
import com.adriano.avaliacao.sinerji.service.SinerjiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinerji")
@AllArgsConstructor
public class SinerjiResource {

    private SinerjiService service;

    @GetMapping("/cargos")
    public List<Cargo> cargos(){
        return service.cargos();
    }
    @GetMapping("/funcionarios")
    public List<Contrato> funcionarios(){
        return service.funcionarios();
    }
    @GetMapping("/vendas")
    public List<Venda> vendas(){
        return service.vendas();
    }
    @GetMapping("/vendas/{mes}/{ano}")
    public List<Venda> vendas(@PathVariable(name = "mes") short mes,
                              @PathVariable(name = "ano") short ano){
        return service.vendas(new Competencia(ano, mes));
    }


    @PostMapping("/valorTotal/{mes}/{ano}")
    public float valorTotalPago(@PathVariable(name = "mes") short mes,
                                @PathVariable(name = "ano") short ano,
                                @RequestBody List<Contrato> request){
        return service.valorTotalPago(request, new Competencia(ano, mes));
    }

    @PostMapping("/valorTotal/{mes}/{ano}/salario")
    public float valorTotalSalario(@PathVariable(name = "mes") short mes,
                                   @PathVariable(name = "ano") short ano,
                                   @RequestBody List<Contrato> request){
        return service.valorTotalSalario(request, new Competencia(ano, mes));
    }

    @PostMapping("/valorTotal/{mes}/{ano}/beneficio")
    public float valorTotalBeneficio(@PathVariable(name = "mes") short mes,
                                     @PathVariable(name = "ano") short ano,
                                     @RequestBody List<ContratoBeneficio> request){
        return service.valorTotalBeneficio(request, new Competencia(ano, mes));
    }

    @PostMapping("/maiorValor/{mes}/{ano}")
    public String maiorValorTotal(@PathVariable(name = "mes") short mes,
                                  @PathVariable(name = "ano") short ano,
                                  @RequestBody List<Contrato> request){
        return service.maiorValorTotal(request, new Competencia(ano, mes)).getNome();
    }

    @PostMapping("/maiorValor/{mes}/{ano}/beneficio")
    public String  maiorValorBeneficio(@PathVariable(name = "mes") short mes,
                                       @PathVariable(name = "ano") short ano,
                                       @RequestBody List<ContratoBeneficio> request){
        return service.maiorValorBeneficio(request, new Competencia(ano, mes)).getNome();
    }

    @PostMapping("/maiorValor/{mes}/{ano}/vendas")
    public String  maiorValorVendas(@PathVariable(name = "mes") short mes,
                                    @PathVariable(name = "ano") short ano,
                                    @RequestBody List<Vendedor> request){
        return service.maiorValorVendas(request, new Competencia(ano, mes)).getNome();
    }
}
