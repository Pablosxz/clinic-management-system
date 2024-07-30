# Gerenciamento de Clinica

Este é um projeto para gerenciamento de clínicas, incluindo funcionalidades para autenticação, agendamentos, gerenciamento de pacientes, médicos e recuperação de senhas. Desenvolvido com Spring Boot, utilizando PostgreSQL e documentação Swagger.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Mail
- Springdoc OpenAPI (Swagger)
- PostgreSQL

## Funcionalidades

- Autenticação de usuários (login e logout)
- Registro de novos usuários
- Recuperação de senha por email
- CRUD de agendamentos
- CRUD de pacientes
- CRUD de médicos
- Documentação da API com Swagger

## Requisitos

- Java 17
- Maven
- PostgreSQL

## Configuração do Ambiente

1. Clone o repositório:
   ```bash
   git clone https://github.com/Pablosxz/clinic-management-system.git
   cd clinic-management-system

2. Configure as variáveis de ambiente
   Linux/MacOS:
   ```bash
   export DB_HOST=localhost
   export DB_PORT=5432
   export DB_NAME=clinicadb
   export DB_USERNAME=your_db_username
   export DB_PASSWORD=your_db_password
   export MAIL_USERNAME=your_email@example.com
   export MAIL_PASSWORD=your_email_password
   ```
   
   Windows (PowerShell):
   ```bash
   $env:DB_HOST="localhost"
   $env:DB_PORT="5432"
   $env:DB_NAME="clinicadb"
   $env:DB_USERNAME="your_db_username"
   $env:DB_PASSWORD="your_db_password"
   $env:MAIL_USERNAME="your_email@example.com"
   $env:MAIL_PASSWORD="your_email_password"
   ```
3. Copie o arquivo application.properties.example para application.properties:
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties

4. Execute o projeto:
   ```bash
   mvn spring-boot:run

# Endpoints da API

## Autenticação
- **POST** `/api/v1/auth/login`: Fazer login
- **POST** `/api/v1/auth/logout`: Fazer logout
- **GET** `/api/v1/auth/current`: Retorna o usuário autenticado atualmente

## Paciente
- **PUT** `/api/v1/paciente/{pacienteId}`: Atualizar paciente
- **DELETE** `/api/v1/paciente/{pacienteId}`: Deletar paciente
- **GET** `/api/v1/paciente`: Obter pacientes
- **POST** `/api/v1/paciente`: Registrar paciente

## Agendamento
- **PUT** `/api/v1/agendamento/{agendamentoId}`: Atualizar agendamento
- **DELETE** `/api/v1/agendamento/{agendamentoId}`: Deletar um agendamento
- **GET** `/api/v1/agendamento`: Obter todos os agendamentos
- **POST** `/api/v1/agendamento`: Registrar novo agendamento

## PasswordReset
- **POST** `/api/v1/password-reset/reset`: Realizar reset
- **POST** `/api/v1/password-reset/request`: Requisitar reset

## Registro
- **POST** `/api/v1/register`: Registrar usuário

## Médico
- **PUT** `/api/v1/medico/{medicoId}`: Atualizar informações do médico
- **DELETE** `/api/v1/medico/{medicoId}`: Deletar um médico
- **GET** `/api/v1/medico`: Obter médicos
- **POST** `/api/v1/medico`: Registrar um novo médico

## Documentação
A documentação da API pode ser acessada em:

    
    http://localhost:8080/swagger-ui/index.html
    

# Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.
