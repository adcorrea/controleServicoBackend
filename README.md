# CONTROLE DE SERVIÇO RESTFULL

Backend do portal de serviços em Angular




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

