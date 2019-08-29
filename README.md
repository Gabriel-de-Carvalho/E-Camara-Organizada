# E-Camara-Organizada


Aplicação Backend desenvolvida utilizando-se da linguagem Java e do framework Spring Boot.

Em resumo essa API é capaz de simular o processo lesgislativo brasileiro. Com Rotas e controllers definidos para o cadastro de pessoas e deputados, alem de comissões, partidos e propostas de leis.  

## Rotas

### Pessoas e Deputados

Metodo: @Post  
Rota: "/v1/pessoa/ComPartido"  
Recebe uma Pessoa com afiliação partidaria e a cadastra no sistema. Esta Pessoa possuindo um nome, um dni, estado, lista de interesses e partido.  

Metodo: @Post  
Rota: "/v1/pessoa/SemPartido"  
Recebe uma Pessoa sem afiliação partidaria e a cadastra no sistema. Esta Pessoa possuindo um nome, um dni e estado, lista de interesses.  

Metodo: @put  
Rota: "/v1/Deputado"  
Realiza o cadastro de um deputado no sistema. Esse deputado deve ser uma pessoa previamente cadastrada no sistema e deve possuir afialiação partidaria. É necessario o Dni e data de inicio do mandato.  

Metodo: @Get    
Rota: "/v1/pessoa/{dni}"  
Recupera uma pessoa cadastrada no sistema atraves do seu identificador, um dni.  


Metodo: @Get  
Rota: "/v1/deputado/{dni}"  
Recupera um deputado cadastrado no sistema atraves do seu identificador, um dni.  

### Partidos

Metodo: @Post  
Rota: "/v1/partido/"  
Faz o cadastro de um partido, Sendo este pertencendo a base aliada do governo. Passa-se o nome do partido.  

Metodo: @Get  
Rota: "/v1/partido/"  
Recupera a base aliada.  

### Comissão

Metodo: @Post  
Rota: "/v1/Comissao/"  
Faz o cadastro de uma comissão especializada. É passado o nome do tema pelo qual a comissao é responsavel, alem de uma lita de dni's dos deputados participantes.  


### Propostas de Leis

Metodo: @Post  
Rota: "/v1/Ementa"  
Faz o cadastro de uma Ementa. Esta possuindo um autor, lista de interesses, ano, ementa, um endereço, e artigos.  

Metodo: @Post  
Rota: "/v1/LeiComplementar"  
Realiza o cadastro de uma Lei Complementar. Esta possuindo um autor, lista de interesses, ano, ementa, um endereço, e artigos.  

Metodo: @Post  
Rota: "/v1/ProjetoLei"  
Realiza o cadastro de um Projeto de Lei. Esta possuindo um autor, lista de interesses, ano, ementa, um endereço, e um status se é conclusiva ou nao.  

Metodo: @Get  
Rota:"/v1/Ementa/{Codigo}"  
Recupera uma Ementa e suas propriedades.  

Metodo: @Get  
Rota: "/v1/LeiComplementar/{Codigo}"  
Recupera uma LP e suas propriedades.  

Metodo: @Get  
Rota: "/v1/ProjetoLei/{Codigo}"  
Recupera um Projeto de Lei e suas propriedades.  

