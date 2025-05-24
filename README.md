# Spring Security Base Project

Projeto criado para praticar Spring Security e servir como um modelo base reutilizável para acelerar a implementação de segurança em outros projetos. Este repositório oferece uma estrutura pronta, com boas práticas aplicadas, para facilitar a integração rápida de autenticação e autorização em aplicações Spring Boot, permitindo que você "copie e cole" as configurações essenciais e foque mais na lógica do seu negócio.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.0
- Spring Security
- Lombok
- JWT
- PostgreSQL (via Docker Compose)

## Sobre o Projeto

Este projeto tem como objetivo ser um template ou ponto de partida para a segurança em aplicações Spring Boot. Ele contém configurações básicas e exemplos de autenticação, autorização, e gerenciamento de usuários que podem ser facilmente adaptados e reutilizados em outros projetos, poupando tempo e esforço no desenvolvimento.

## Como Rodar

### Requisitos

- Java 21 instalado
- Docker e Docker Compose instalados

### Passos para iniciar o projeto

1. Suba o container do banco de dados PostgreSQL com Docker Compose:

```bash
docker compose up -d