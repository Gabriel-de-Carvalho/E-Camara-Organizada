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

### Pessoas e Deputados

Metodo: @Post  
Rota: "pessoa/ComPartido"  
Recebe uma Pessoa com afiliação partidaria e a cadastra no sistema. Esta Pessoa possuindo um nome, um dni, estado, lista de interesses e partido.  

Metodo: @Post  
Rota: "pessoa/SemPartido"  
Recebe uma Pessoa sem afiliação partidaria e a cadastra no sistema. Esta Pessoa possuindo um nome, um dni e estado, lista de interesses.  

Metodo: @put  
Rota: "Deputado"  
Realiza o cadastro de um deputado no sistema. Esse deputado deve ser uma pessoa previamente cadastrada no sistema e deve possuir afialiação partidaria. É necessario o Dni e data de inicio do mandato.  

Metodo: @Get    
Rota: "pessoa/{dni}"  
Recupera uma pessoa cadastrada no sistema atraves do seu identificador, um dni.  


Metodo: @Get  
Rota: "deputado/{dni}"  
Recupera um deputado cadastrado no sistema atraves do seu identificador, um dni.  

### Partidos

Metodo: @Post  
Rota: "partido/"  
Faz o cadastro de um partido, Sendo este pertencendo a base aliada do governo. Passa-se o nome do partido.  

Metodo: @Get  
Rota: "partido/"  
Recupera a base aliada.  

### Comissão

Metodo: @Post  
Rota: "Comissao/"  
Faz o cadastro de uma comissão especializada. É passado o nome do tema pelo qual a comissao é responsavel, alem de uma lita de dni's dos deputados participantes.  


### Propostas de Leis

Metodo: @Post  
Rota: "Ementa"  
Faz o cadastro de uma Ementa. Esta possuindo um autor, lista de interesses, ano, ementa, um endereço, e artigos.  

Metodo: @Post  
Rota: "LeiComplementar"  
Realiza o cadastro de uma Lei Complementar. Esta possuindo um autor, lista de interesses, ano, ementa, um endereço, e artigos.  

Metodo: @Post  
Rota: "ProjetoLei"  
Realiza o cadastro de um Projeto de Lei. Esta possuindo um autor, lista de interesses, ano, ementa, um endereço, e um status se é conclusiva ou nao.  

Metodo: @Get  
Rota:"Ementa/{Codigo}"  
Recupera uma Ementa e suas propriedades.  

Metodo: @Get  
Rota: "LeiComplementar/{Codigo}"  
Recupera uma LP e suas propriedades.  

Metodo: @Get  
Rota: "ProjetoLei/{Codigo}"  
Recupera um Projeto de Lei e suas propriedades.  

