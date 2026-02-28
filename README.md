📌 FórumHub API
API REST desenvolvida com Spring Boot para gerenciamento de tópicos de um fórum.
O projeto implementa autenticação segura utilizando Spring Security e JWT (JSON Web Token), garantindo que apenas usuários autenticados possam acessar e manipular os dados da API.
🚀 Funcionalidades implementadas
📚 Tópicos
✅ Cadastro de tópico (POST /topicos)
✅ Listagem de tópicos (GET /topicos)
✅ Detalhamento por ID (GET /topicos/{id})
✅ Atualização de tópico (PUT /topicos/{id})
✅ Exclusão de tópico (DELETE /topicos/{id})
🔐 Segurança
✅ Autenticação com login e senha
✅ Geração de token JWT
✅ Validação automática do token em cada requisição
✅ Filtro de autenticação personalizado
✅ Proteção de rotas (somente usuários autenticados acessam os endpoints)
🛡 Regras de Negócio
✅ Validação de dados obrigatórios
✅ Prevenção de tópicos duplicados
✅ Retorno adequado de status HTTP (200, 201, 204, 400, 401, 403, 404)
🗄 Banco de Dados
✅ Persistência com MySQL
✅ Migrations com Flyway
🧪 Testes
✅ Testes realizados no Postman
🔐 Como funciona a autenticação
1️⃣ Gerar Token
POST


http://localhost:8080/login
Body:
Json

{
  "login": "admin@forum.com",
  "senha": "123456"
}
Resposta:
Json

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJmb3J1bWh1YiIsInN1YiI6ImFkbWluQGZvcnVtLmNvbSIsImV4cCI6MTc3MjMyMDM0Mn0.vlgxK1cEWiEGb3bMUfNRVxcIVqVqqvTkgwOx6nkGrHw"
}
2️⃣ Usar o Token nas próximas requisições
No Postman:
Auth → Bearer Token → cole o token
Ou via header:


Authorization: Bearer SEU_TOKEN_AQUI
Todos os endpoints de /topicos exigem token válido.
🛠 Tecnologias utilizadas
Java 21
Spring Boot
Spring Web
Spring Data JPA
Spring Security
JWT (Auth0 – java-jwt)
MySQL
Flyway
Maven
🧠 Conceitos aplicados
Arquitetura em camadas (Controller, Service, Repository)
DTOs para entrada e saída de dados
Bean Validation
Autenticação com Spring Security
Geração e validação de JWT
Filtro de autenticação customizado
Controle de acesso via token
Tratamento de exceções e status HTTP
Versionamento com Git
▶ Como executar o projeto
Clone o repositório:


git clone https://github.com/carolbelfort/forumhub.git
Configure o banco MySQL
Ajuste o application.properties:
Properties

spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=root
spring.datasource.password=sua_senha

jwt.secret=sua_chave_secreta
jwt.expiration=3600000
Execute o projeto:


mvn spring-boot:run
Teste via Postman.
🏆 Resultado
Este projeto demonstra:
✔ Implementação completa de API REST
✔ Integração com banco relacional
✔ Segurança com JWT
✔ Boas práticas com Spring Boot
✔ Organização em camadas
✔ Controle de acesso protegido
Projeto pronto para portfólio e processos seletivos.
