# Sistema de Gestão de Veículos

Sistema CRUD para gerenciamento de estoque de veículos desenvolvido utilizando Java, Spring Boot e MySQL.

## Objetivo

O projeto tem como objetivo permitir o gerenciamento de veículos através de operações de cadastro, consulta, atualização e remoção de dados utilizando uma API REST.

---

## Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* MySQL 
* HTML / JavaScript

---

## Funcionalidades

* Cadastro de marcas
* Cadastro de modelos
* Cadastro de veículos
* Consulta de veículos
* Filtros por ano e outras informações
* Atualização de dados
* Remoção de veículos

---

## Arquitetura

O sistema foi desenvolvido utilizando arquitetura em camadas:

* Controller → Recebe as requisições HTTP
* Service → Regras de negócio e validações
* Repository → Acesso ao banco de dados

---

## Endpoints Principais

### Veículos

| Método | Endpoint           | Descrição        |
| ------ | ------------------ | ---------------- |
| GET    | /api/veiculos      | Lista veículos   |
| POST   | /api/veiculos      | Cadastra veículo |
| PUT    | /api/veiculos/{id} | Atualiza veículo |
| DELETE | /api/veiculos/{id} | Remove veículo   |

---

## Exemplo de Requisição

```json
{
  "modelo": { "id": 1 },
  "ano": 2022,
  "cor": "Preto",
  "preco": 55000,
  "quilometragem": 30000,
  "status": "DISPONIVEL"
}
```

---

## Como Executar

1. Clonar o repositório
2. Configurar o arquivo `application.properties` com os dados do seu banco MySQL antes de executar a aplicação.
3. Executar o projeto Spring Boot
4. Acessar a API em: `http://localhost:8080`

---

## Conceitos Aplicados

* Programação Orientada a Objetos
* Encapsulamento
* Herança
* API REST
* Arquitetura MVC

---

## Autor

Willian Emanoel
RA: 41620
