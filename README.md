# CONTROLE DE SERVIÇO RESTFULL

Backend do portal de serviços em Angular

## FRONTEND
O frontend da aplicação está no git https://github.com/adcorrea/controle-servico-front.


POST CLIENTE

curl --location 'http://localhost:8080/clientes/' \
--header 'Content-Type: application/json' \
--data '{
"nome": "Marcelo Taz",
"cpf": "74314706066"
}'

GET CLIENTE

curl --location 'http://localhost:8080/clientes/'

GET CLIENTE BY ID

curl --location 'http://localhost:8080/clientes/'

DELETE CLIENTE BY ID

curl --location --request DELETE 'http://localhost:8080/clientes/2'

PUT CLIENTE

curl --location --request PUT 'http://localhost:8080/clientes/1' \
--header 'Content-Type: application/json' \
--data '{
"nome": "Marcelo Taz",
"cpf": "74314706066"
}'

POST Serviço Prestado

curl --location 'http://localhost:8080/api/servicos-prestados' \
--header 'Content-Type: application/json' \
--data '{
"descricao" : "Manutencao Hack",
"data" : "22/04/2023",
"idCliente" : 1,
"preco" : "1200,00"
}'

PUT Serviço Prestado

curl --location --request PUT 'http://localhost:8080/api/servicos-prestados/1' \
--header 'Content-Type: application/json' \
--data '{
"id": 1,
"descricao": "Manutencao Hack",
"cliente": {
"id": 1,
"nome": "Antonio Junior",
"cpf": "50886053072",
"dataCadastro": "22/04/2023"
},
"valor": 110.00,
"data": "2023-04-22"
}'

GET all

curl --location 'http://localhost:8080/api/servicos-prestados/'

GET by id

curl --location 'http://localhost:8080/api/servicos-prestados/1'


GET busca

curl --location 'http://localhost:8080/api/servicos-prestados/busca?nome=junior&mes=4'

DELETE

curl --location --request DELETE 'http://localhost:8080/api/servicos-prestados/1'



## Security

POST Usuario

curl --location 'http://localhost:8080/api/usuarios' \
--header 'Content-Type: application/json' \
--data '{
"username": "adcorrea",
"password": "1234"
}'

POST JWT

curl --location 'http://localhost:8080/oauth/token' \
--header 'Authorization: Basic bXktYW5ndWxhci1hcHA6QDMyMQ==' \
--form 'username="admin"' \
--form 'password="1234"' \
--form 'grant_type="password"'