# Iniciar o projeto
- ###### Docker instalado
- ###### utilizado jdk21
# 
- mvn clean install
- docker-compose build
- docker-compose up
#
- http://localhost:8288/sinerji/funcionarios
###### retorna a lista de funcionários
##### Utilizar o _response_ do _endpoint_ acima como _body_ para os _endpoints_ seguintes:

Ex: http://localhost:8288/sinerji/valorTotal/{mes}/{ano}
#
## considerando 01/2022

1. http://localhost:8288/sinerji/valorTotal/1/2022
2. http://localhost:8288/sinerji/valorTotal/1/2022/salario
3. http://localhost:8288/sinerji/valorTotal/1/2022/beneficio
   - aceitará apenas funcionários com benefícios (__secretario__ e __vendedor__)
4. http://localhost:8288/sinerji/maiorValor/1/2022
5. http://localhost:8288/sinerji/maiorValor/1/2022/beneficio
   - aceitará apenas funcionários com benefícios (__secretario__ e __vendedor__)
6. http://localhost:8288/sinerji/maiorValor/1/2022/vendas
   - aceitará apenas __vendedores__
