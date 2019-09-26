# E-Camara-Organizada


Aplicação Backend desenvolvida utilizando-se da linguagem Java e do framework Spring Boot.

Em resumo essa API é capaz de simular o processo lesgislativo brasileiro. Com Rotas e controllers definidos para o cadastro de pessoas e deputados, alem de comissões, partidos e propostas de leis.  

## Instalação e Execução
Primeiramente, Devemos clonar localmente esse repositorio para se poder executar a API.   
Para isso, então, deve-se ter o git instalado na máquina, caso não o tenha siga esse tutorial para instalação usando sua plataforma como referência: [instalação do git](https://git-scm.com/book/pt-br/v1/Primeiros-passos-Instalando-Git.)  

Após Isso, abra então seu terminal, navegue até o local onde se deseja salvar localmente esse projeto. Quando estiver pronto, utilize o comando:
> $ Git Clone https://github.com/Gabriel-de-Carvalho/E-Camara-Organizada.git  

Uma vez criada a copia local, para executar, basta navegar, a partir do seu terminal,  para `E-Camara-Organizada/Aplicação`. Então execute o comando:
> $ mvn spring-boot:run  

## Autenticação

O sistema de autenticação, usado para garantir a proteção e acesso somente a usuarios autenticados as apropriadas rotas, se baseia em autenticação por token.  

Usuários podem criar a suas contas através de rotas livres para essa finalidade. Uma vez criadas, devem ser autenticadas, checando as credenciais passadas com as que se encontram no sistema. Uma vez checadas, haverá uma resposta contendo o token de acesso. Com ele em mãos, será possivel acessar as rotas da API que entrem dentro das permissões apropriadas para aquele usuário, passando esse token no header "Authorization", em todas as requisições.    

Utilizando-se da estrategia de implementação de um unico filtro para todas as requisições feitas ao sistema, ele ira extrair do header:"Authorization" o token passado, se recupera então as informações contidas dele, nesse caso o nome do usuario, o tempo de expiração do token e se está formatado da maneira correta. As informações então são checadas e caso haja confirmação, a requisição no final é levada para seu service apropriado.  
