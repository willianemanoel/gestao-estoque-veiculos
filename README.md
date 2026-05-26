# Sistema de Gestão de Veículos

Sistema CRUD para gerenciamento de estoque de veículos desenvolvido utilizando Java, Spring Boot e MySQL.

## Objetivo

O projeto tem como objetivo permitir o gerenciamento de veículos por meio de operações de cadastro, consulta, atualização e remoção de dados utilizando uma API REST integrada a um banco de dados MySQL.

---

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- HTML
- CSS
- JavaScript

---

## Funcionalidades

- Cadastro de marcas
- Cadastro de modelos
- Cadastro de veículos
- Consulta de veículos
- Filtros por marca
- Filtros por modelo
- Filtros por ano
- Filtros por preço
- Filtros por status
- Atualização de dados
- Remoção de veículos

---

## Arquitetura

O sistema foi desenvolvido utilizando arquitetura em camadas:

- Controller → Responsável pelas requisições HTTP
- Service → Responsável pelas regras de negócio e validações
- Repository → Responsável pelo acesso ao banco de dados

---

## Endpoints Principais

### Veículos

| Método | Endpoint           | Descrição              |
|--------|-------------------|------------------------|
| GET    | /api/veiculos     | Lista os veículos      |
| POST   | /api/veiculos     | Cadastra um veículo    |
| PUT    | /api/veiculos/{id}| Atualiza um veículo    |
| DELETE | /api/veiculos/{id}| Remove um veículo      |

---

## Exemplo de Requisição

```json
{
  "modelo": { "id": 1 },
  "ano": 2022,
  "cor": "Preto",
  "preco": 55000,
  "quilometragem": 30000,
  "status": "Disponivel"
}
```

---

## Como Executar

1. Clonar o repositório
2. Configurar o arquivo `application.properties` com os dados do banco MySQL
3. Executar o projeto Spring Boot
4. Acessar o sistema em:

```bash
http://localhost:8080
```

---

## Conceitos Aplicados

- Programação Orientada a Objetos
- Encapsulamento
- Herança
- API REST
- Arquitetura em Camadas
- CRUD
- Persistência de Dados com JPA

---

## Autor

Willian Emanoel  
RA: 41620
