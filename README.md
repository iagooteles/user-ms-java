# 📦 Microserviço de Usuários

Este projeto é um microserviço desenvolvido em **Java com Spring Boot** para cadastro e listagem de usuários. Os dados são armazenados em um banco de dados **PostgreSQL** containerizado com **Docker**.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Docker
- Jakarta Validation

## 🔧 Endpoints

| Método | Rota      | Descrição                     |
|--------|-----------|-------------------------------|
| GET    | `/users`  | Lista todos os usuários       |
| POST   | `/users`  | Cadastra um novo usuário      |

## 💡 Como Rodar

> Pré-requisitos: Docker e Java 17+ instalados

1. **Suba o container do banco PostgreSQL** (exemplo com Docker Compose ou linha de comando)
2. **Configure o `application.properties` para conectar no banco**
3. **Execute a aplicação Spring Boot**

## 📚 Organização do Projeto

O projeto está dividido em camadas bem definidas seguindo boas práticas:

- `controllers`: responsável por lidar com as requisições HTTP.
- `dtos`: objetos de transferência de dados usados nas requisições.
- `models`: entidades que representam as tabelas no banco de dados.
- `repository`: interface que estende o `JpaRepository` para acesso ao banco.
- `services`: camada responsável pela lógica de negócio da aplicação.

---

## Projeto em construção .....

