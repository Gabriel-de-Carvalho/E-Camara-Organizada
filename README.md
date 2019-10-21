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
1. Clone o repositorio:
```console 
user@:$ Git Clone https://github.com/Gabriel-de-Carvalho/E-Camara-Organizada.git
```
1. Navegue até a pasta Aplicação:
```console 
user@:$ cd E-Camara-Organizada/Aplicação
```
1. Execute o comando para iniciar o programa:
```console 
user@:$ mvn spring-boot:run
```

## Arquitetura

## Autenticação

O sistema de autenticação, usado para garantir a proteção e acesso somente a usuarios autenticados as rotas apropriadas, se baseia em autenticação por token.  

Usuários podem criar a suas contas através de rotas livres para essa finalidade: `"/v1/auth/signup"`. Uma vez criadas, devem ser autenticadas: `"/v1/auth/signin"`, checando as credenciais passadas com as que se encontram no sistema. Uma vez checadas, haverá uma resposta contendo o token de acesso. Com ele em mãos, será possivel acessar as rotas da API que entrem dentro das permissões apropriadas para aquele usuário, passando esse token no header "Authorization", em todas as requisições.    

Utilizando-se da estrategia de implementação de um unico filtro para todas as requisições feitas ao sistema, ele ira extrair do header:"Authorization" o token passado, se recupera então as informações contidas dele, nesse caso o nome do usuario, o tempo de expiração do token e se está formatado da maneira correta. As informações então são checadas e caso haja confirmação, a requisição no final é levada para seu service apropriado.  
