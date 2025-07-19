# 📦 Microserviço de Usuários

Este projeto é um microserviço desenvolvido em **Java com Spring Boot** para cadastro e listagem de usuários. Os dados são armazenados em um banco de dados **PostgreSQL** containerizado com **Docker**. Esse projeto se comunica de forma assíncrona com o microserviço de envio de e-mails através do RabbitMQ. Os dados são armazenados em um banco PostgreSQL, executado em container Docker.

📧 Este serviço trabalha em conjunto com o microserviço de email, que consome as mensagens da fila e realiza o envio.

Repositório do microserviço de email (TODO: adicionar depois)=>

```bash

```

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring AMQP (RabbitMQ)
- PostgreSQL
- Docker
- Jakarta Validation

---

## ✉️ Integração com RabbitMQ

Ao cadastrar um novo usuário, o serviço envia uma mensagem para o RabbitMQ com os dados necessários para o envio de um e-mail de boas-vindas. Essa mensagem é consumida pelo microserviço de email.

Este microserviço utiliza RabbitMQ como broker de mensagens para comunicação assíncrona com outros serviços.

A classe UserProducer envia mensagens para a fila de emails sempre que um novo usuário é cadastrado.

A mensagem enviada é um objeto EmailDto, serializado em JSON com Jackson2JsonMessageConverter.

A fila utilizada é configurada via propriedade ${broker.queue.email.name} no application.properties.

## 📁 Arquivos relacionados:

configs/RabbitMQConfig.java: configura o conversor de mensagens para JSON.

producers/UserProducer.java: responsável por publicar a mensagem com os dados do email.

## 🔧 Endpoints

| Método | Rota      | Descrição                     |
|--------|-----------|-------------------------------|
| GET    | `/users`  | Lista todos os usuários       |
| POST   | `/users`  | Cadastra um novo usuário      |

## 💡 Como Rodar

> Pré-requisitos: Docker e Java 17+ instalados

1. **Suba o container do banco PostgreSQL** (exemplo com Docker Compose ou linha de comando)
2. Garanta que o RabbitMQ esteja rodando localmente ou em nuvem (ex: CloudAMQP).
3. **Configure o `application.properties` para conectar no banco**
4. **Execute a aplicação Spring Boot**

## 📚 Organização do Projeto

O projeto está dividido em camadas bem definidas seguindo boas práticas:

- `controllers`: responsável por lidar com as requisições HTTP.
- `dtos`: objetos de transferência de dados usados nas requisições.
- `models`: entidades que representam as tabelas no banco de dados.
- `repository`: interface que estende o `JpaRepository` para acesso ao banco.
- `services`: camada responsável pela lógica de negócio da aplicação.
- `producers`: componentes responsáveis por publicar mensagens na fila.
- `configs`: configurações do projeto (incluindo RabbitMQ).

---
