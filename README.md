# 2ibichallenge

Criei esse repostiório para salvar o projeto que fiz solucionando o pedido do desafio da 2iBi.

## SOBRE A API

É uma API onde é possível gerenciar as informaçoes de países. Foi criado uma classe modelo onde nela tem as informações do país(identificador – gerado automaticamente, nome, capital, região, sub-região, área).

## INSTRUÇÕES

Neste projeto há um arquivo chamado `CHALLENGE-2IBI.postman_collection.json` que contém todas as rotas da API. Para importar as rotas no Postman, basta clicar em `Import` e selecionar o arquivo.

## ROTAS

A URL base da API é `2ibichallenge-production.up.railway.app`.

### GET

`/country` - Retorna todos os países cadastrados.

`/country/{id}` - Retorna o país com o id informado.

### POST

`/country` - Cria um novo país.

O body da requisição deve ser um JSON com as seguintes informações:

```json
{
    "name": "Brasil",
    "capital": "Brasília",
    "region": "Americas",
    "subregion": "South America",
    "area": 8515767
}
```

### PATCH

`/country/{id}` - Atualiza o país com o id informado.

O ID é passado na URL e as informações a serem atualizadas são passadas no body da requisição.

Optei por utilzar o método PATCH para atualizar o país, pois assim é possível atualizar apenas uma informação do país, sem precisar enviar todas as informações novamente.

O body da requisição deve ser um JSON com as seguintes informações:

```json
{
    "name": "Brasil",
    "capital": "Brasília",
    "region": "Americas",
    "subregion": "South America",
    "area": 8515767
}
```

### DELETE

`/country/{id}` - Deleta o país com o id informado.