# Spring Security JWT – RBAC API

Projeto backend desenvolvido para estudo e prática de **Spring Security**, utilizando **JWT assinado com RSA**, **autenticação stateless** e **controle de acesso por roles (RBAC)**.  
A estrutura e as decisões do projeto seguem padrões comuns utilizados em aplicações reais.

---

## 🛠️ Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Security
- OAuth2 Resource Server
- JWT (RSA)
- JPA / Hibernate
- MySQL
- Docker & Docker Compose
- Maven

---

## 🔐 Funcionalidades
- Autenticação com JWT (stateless)
- Geração de token assinado com chaves RSA
- Autorização baseada em roles (`ADMIN`, `BASIC`)
- Controle de acesso com `@PreAuthorize`
- Criptografia de senhas com BCrypt
- Integração com banco de dados MySQL
- Testes de autenticação via Insomnia

---

## 🧠 Conceitos Aplicados
- Stateless Authentication
- RBAC (Role-Based Access Control)
- OAuth2 Scopes (`SCOPE_ADMIN`, `SCOPE_BASIC`)
- Separação de responsabilidades (Controller, Repository)
- Boas práticas de segurança (secrets fora do repositório)
- Configuração por ambientes (local / docker)

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Maven
- Docker e Docker Compose

---

### 1️⃣ Subir o banco de dados (Docker)

Acesse a pasta `docker/` e execute:

```bash
docker compose up -d

O MySQL será iniciado utilizando variáveis de ambiente definidas em um arquivo `.env` (não versionado).

---

### 2️⃣ Configuração local da aplicação

As configurações sensíveis **não fazem parte do repositório**.  
Para execução local, utilize um profile específico.

Crie o arquivo abaixo (ignorado pelo Git):
```

```text
src/main/resources/application-local.properties

spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=admin
spring.datasource.password=123

mvn spring-boot:run -Dspring.profiles.active=local
```
3️⃣ Autenticação

O login retorna um JWT assinado com RSA.

O token deve ser enviado nas requisições protegidas através do header:

Authorization: Bearer <token>

4️⃣ Autorização (RBAC)

- A autorização é baseada em roles:

ADMIN

BASIC

- As roles são convertidas em OAuth2 scopes, resultando em authorities como:

SCOPE_ADMIN

SCOPE_BASIC

- Endpoints protegidos utilizam @PreAuthorize.

Exemplo:

@PreAuthorize("hasAuthority('SCOPE_ADMIN')")


Usuários sem a permissão necessária recebem 403 Forbidden.

5️⃣ Testes com Insomnia

- Os testes de autenticação e autorização foram realizados utilizando o Insomnia, com automação para:

- Capturar o JWT após o login

- Armazenar o token em variável de ambiente

- Reutilizar o token em endpoints protegidos

- Esse fluxo facilita a validação de permissões entre usuários ADMIN e BASIC.

🔒 Segurança

- Senhas são armazenadas utilizando BCrypt

- Chaves RSA e variáveis de ambiente não são versionadas

- Arquivos sensíveis são ignorados via .gitignore

- O projeto segue boas práticas de segurança para APIs REST

🎯 Objetivo

Consolidar conhecimentos em Spring Security, JWT, OAuth2 Resource Server e controle de acesso, servindo como base de estudo e portfólio backend.

---

**Desenvolvido por Eder Souza Silva**
