# E-Camara-Organizada


Aplicação Backend desenvolvida utilizando-se da linguagem Java e do framework Spring Boot.

Em resumo essa API é capaz de simular o processo lesgislativo brasileiro. Com as possibilidades de:
* Cadastrar e recuperar pessoas
* Cadastrar e recuperar deputados a partir de pessoas existentes no sistema
* Cadastrar e recuperar partidos
* Cadastrar e recuperar projetos de lei, Ementa e leis complementares
* Cadastrar e recuperar comissões
* Realizar a simulação de votação para projetos em andamento.
   

## Instalação e Execução
Primeiramente, Devemos clonar localmente esse repositorio para se poder executar a API.  
Para isso, então, deve-se ter o git instalado na máquina, caso não o tenha siga esse tutorial para instalação usando sua plataforma como referência: [instalação do git](https://git-scm.com/book/pt-br/v1/Primeiros-passos-Instalando-Git.)  

1. abra seu terminal.
1. Clone o repositorio: `$ Git Clone https://github.com/Gabriel-de-Carvalho/E-Camara-Organizada.git`
1. Navegue até a pasta Aplicação: `$ cd E-Camara-Organizada/Aplicação`
1. Execute o comando para iniciar o programa: `$ mvn spring-boot:run`


## Arquitetura

Baseada na arquitetura cliente-servidor de 3 camadas. nas quais:  
* Servidor web: Responsavel por receber requisições feitas pelo cliente(Browser), envia-las para a camada de negócio onde será processada e retornar uma resposta adequada para o cliente.
* Camada de negócio: Coleção de funções onde serão feitos os processamentos dos pedidos passados pela camada web.
* Camada de dados: Repositório de dados, onde estão armazenadas todas as informações e é realizada a persistência das entidades pertencentes ao programa.  
  
  
  
![fluxo](https://i.ibb.co/qj04PfN/eco-1.jpg)


## Autenticação

O sistema de autenticação, usado para garantir a proteção e acesso somente a usuarios autenticados as rotas apropriadas, se baseia em autenticação por token. 

É necessario criar e autenticar uma conta para ter acesso.

* Para cadastro, realizarum POST em `"/v1/auth/signup"`
    *Email, senha e nome são necessarios e nao devem ser nulos  
    
Autenticação e fluxo de funcionamento:  
1. Credenciais são passadas em um POST para: `"/v1/auth/signin"`.
2. Este passará pelos filtros de autenticação.
3. Uma vez confirmada, receberá de volta o token de acesso.
4. Para acessar quaisquer rotas, é necessário colocar o token no header "Authorization".
    * retornará um erro caso esteja formatado da maneira errada.
    * retornará um erro caso as informações contidas no token não estejam de acordo com o que está salvo no sistema.
    * Tentar acessar uma rota que esteja fora de seus direitos de usuário.

Em resumo do funcionamento, o filto aplicado irá retirar o token que está sendo passado, retirando as informações dele. Caso estejam de acordo com o que está salvo nas informações do usuário.
Para mais detalhes: [Json Web Token](https://medium.com/tableless/entendendo-tokens-jwt-json-web-token-413c6d1397f6)
