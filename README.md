# SOA - Microservices and Web Engineering

## Checkpoint 3 | 1º Semestre | 2025 - 3 SIR

# CRUD para Gerenciamento de Pacientes

## Desenvolvido por

- **Paulo Henrique** | RM 552444  
- **Pedro Cavariani** | RM 551380  

---

## 📋 Descrição do Projeto

Este projeto consiste no desenvolvimento de uma **API RESTful** para o gerenciamento de uma agenda de pacientes. A aplicação permite realizar operações de **CRUD** (Criar, Ler, Atualizar e Excluir) para as entidades:

- **Paciente**
- **Profissional**
- **Consulta**

---

## ✅ Funcionalidades

### 🧑‍⚕️ Paciente

- Criar um paciente → `POST /pacientes`  
- Deletar um paciente → `DELETE /pacientes/{id}`  
- Atualizar um paciente → `PUT /pacientes/{id}`  
- Buscar todos os pacientes → `GET /pacientes`  
- Buscar paciente por ID → `GET /pacientes/{id}`  

### 👨‍⚕️ Profissional

- Criar um profissional → `POST /profissionais`  
- Deletar um profissional → `DELETE /profissionais/{id}`  
- Atualizar um profissional → `PUT /profissionais/{id}`  
- Buscar todos os profissionais → `GET /profissionais`  
- Buscar profissional por ID → `GET /profissionais/{id}`  

---

## 🔍 Consultas Específicas

- `GET /profissionais/{id}/stats` → Estatísticas de um profissional  
- `GET /pacientes/{id}/consultas?status={AGENDADA,REALIZADA,CANCELADA}&data_de=24-04-2025&data_ate=25-04-2025` → Consultas de um paciente filtradas por status e data  
- `GET /profissionais/{id}/consultas?status={AGENDADA,REALIZADA,CANCELADA}&data_de=24-04-2025&data_ate=25-04-2025` → Consultas de um profissional filtradas por status e data  
- `GET /consultas?status={AGENDADA,REALIZADA,CANCELADA}&data_de=24-04-2025&data_ate=25-04-2025` → Consultas gerais filtradas por status e data  

---

## 🛠️ Tecnologias Utilizadas

- **Spring Boot** → Framework para desenvolvimento da API  
- **Java 17** → Linguagem de programação  
- **Swagger OpenAPI** → Documentação interativa da API  
- **Maven** → Gerenciamento de dependências e build  

---

## ⚙️ Requisitos para Execução

1. **JDK 17** (ou superior) instalado  
2. **Maven** instalado  
3. Configurar corretamente o **Swagger** e o **Docker** (se necessário)  

---

### 📝 Configuração do Swagger

Adicione as seguintes propriedades ao arquivo `application.properties`:

```properties
springdoc.swagger-ui.path=/
springdoc.swagger-ui.disable-swagger-default-url=true
