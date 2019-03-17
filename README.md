# Desafio Backend Banco Pan - SP

Backend Challenge

Projeto desenvolvido com as seguintes tecnologias:

  - Java 8
  - Framework Spring (boot, data, mvc)
  - JPA/Hibernate
  - Banco de dados em memória (H2)
  - Junit com Mockito
  - APIs Rest


Para executar o projeto, siga os seguintes passos:

- Realize o clone do repositório e dentro da IDE desejada e em seguida acesse Arquivo/Importar, selecione a opção Maven/Existing Maven Projects, na próxima tela aponte para o diretório para onde foi feito o clone do projeto do git, e no final clique em Finalizar.

- Em seguida, realize o build do projeto, Clique com o botão direito do mouse sobre a pasta do projeto e navegue até Maven > Update Project. Na próxima tela, clique em OK e aguarde o build do projeto.

- Abra o package com.rafaelfelix.panchallenge; 

- Clique na classe PanChallengeApplication.java 

- Clique com o botão direito do mouse  e navegue para Run As > Java Application. No console, Aguarde o servidor subir, enquanto isso abra o browser (IE, Firefox, Chrome). 

## Lista das APIs disponibilizadas

#### - Consultar Cliente pelo CPF
```
http://localhost:8080/clientes/{cpf}
```

#### - Alterar Endereco Cliente
```
http://localhost:8080/clientes/{id}
```
#### Payload de entrada
```
{
  "telefone1": "",
  "telefone2": "",
  "logradouro": "",
  "numero": "",
  "complemeto": "",
  "bairro": "",
  "cep": "",
  "cidadeId": 0
}
```

#### - Consultar Endereço pelo CEP
```
http://localhost:8080/endereco/{cep}
```

#### - Consultar Estados
```
http://localhost:8080/endereco/estados
```

#### - Consultar Municípios pelo ID do Estado
```
http://localhost:8080/endereco/estado/{id}/municipios
```

## Autor

### Rafael Felix de Moraes

### <a href="mailto:rafaelfelix1433@gmail.com?Subject=Java%20Banco%20Pan" target="_top">Envie-me um e-mail</a>
