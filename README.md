# Sistema de Delivery de Pizzas - API Backend

**Status: Em Desenvolvimento Ativo**

## Visão Geral

Este repositório contém a API backend para a plataforma de delivery de pizzas, concebida como um Software-as-a-Service (SAAS). A arquitetura foi projetada para oferecer a qualquer estabelecimento comercial, como pizzarias, uma solução completa e personalizável para gerenciar seu próprio sistema de pedidos online.

Esta API é a espinha dorsal do sistema, responsável por toda a lógica de negócio, gerenciamento de dados, autenticação de usuários (clientes e administradores) e processamento de pedidos.

## Tecnologias Utilizadas

### Backend

  * **Java 17**
  * **Spring Boot 3** - Framework principal para desenvolvimento da API REST.
  * **Spring Security 6** - Para autenticação e autorização.
      * Autenticação stateless via **JSON Web Token (JWT)**.
      * Login social com **OAuth2 (Google Client)**.
  * **Spring Data JPA (Hibernate)** - Para persistência de dados.
  * **PostgreSQL** - Banco de dados relacional.
  * **SpringDoc (OpenAPI 3)** - Para geração automática de documentação da API (Swagger).

### Frontend (Contexto)

  * **Angular 19**
  * **TypeScript**
  * **Tailwind CSS**

## Funcionalidades da API (Implementadas)

A API é dividida em três domínios de acesso principais, todos protegidos por Spring Security.

### 1\. Clientes (Consumidor Final)

  * **Autenticação:** Sistema completo de registro local (email/senha), login local (gerando JWT) e login social integrado com Google (OAuth2).
  * **Criação de Pedidos:** Endpoint para submissão de pedidos complexos, suportando pizzas (com múltiplos sabores, bordas e adicionais) e bebidas.
  * **Perfil:** Acesso ao histórico de pedidos do cliente logado.

### 2\. Administradores (Lojista SAAS)

  * **Autenticação:** Endpoint de login seguro para o painel administrativo (baseado em JWT).
  * **Dashboard:** API de estatísticas com receita (diária, semanal, mensal), contagem de pedidos e dados para gráficos.
  * **Gestão de Pedidos:** Listagem de todos os pedidos recebidos e atualização de status (Ex: Recebido, Preparando, Em Rota, etc.).
  * **Gestão de Clientes:** CRUD completo para gerenciamento de usuários.
  * **Gestão de Cardápio (CRUD Completo):**
      * **Tipos de Pizza** (Tamanhos).
      * **Sabores de Pizza** (com associação a quais tamanhos estão disponíveis).
      * **Adicionais** (ex: Queijo Extra).
      * **Bordas** (ex: Catupiry).
      * **Bebidas** e **Categorias de Bebidas**.
  * **Upload de Mídia:** Endpoints para upload de imagens para todos os itens do cardápio (Tipos, Sabores, Bebidas).

### 3\. Público (Visitantes)

  * **Cardápio:** Endpoints públicos para listar todos os produtos (pizzas, sabores, bebidas, etc.).
  * **Cardápio Filtrado:** Endpoints para listar sabores, bordas e adicionais disponíveis para um tipo de pizza específico (ex: mostrar apenas sabores de 'Pizza Grande').
  * **Visualização de Pedido:** Endpoint público para checar um pedido específico pelo ID.

## Estrutura do Projeto Backend

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/pizzadelivery/backend/
│   │   │   ├── config/        # Configuração (Security, Swagger, Web)
│   │   │   ├── controller/    # Endpoints da API (Admin, Auth, Customer, Menu, Order)
│   │   │   ├── data/          # Inicialização de dados (DataInitializer)
│   │   │   ├── dto/           # Data Transfer Objects (para requests e responses)
│   │   │   ├── entity/        # Modelos de dados (JPA)
│   │   │   ├── enums/         # Enumerações (Status, Tipos)
│   │   │   ├── mappers/       # Conversores de DTO/Entidade
│   │   │   ├── repository/    # Interfaces Spring Data JPA
│   │   │   ├── security/      # Classes de Segurança (JWT, OAuth2, UserDetails)
│   │   │   └── service/       # Lógica de negócio
│   │   └── resources/
│   │       └── application.properties # Configurações principais
├── uploads/
│   └── images/                # Local de armazenamento de imagens de produtos
├── pom.xml                    # Dependências e build do Maven
└── application-secrets.properties # (Git Ignored) Credenciais e segredos
```

## Instalação e Configuração (Backend)

### Pré-requisitos

  * JDK 17 (ou superior)
  * Maven
  * PostgreSQL (em execução)

### Instalação

1.  Clone o repositório:

    ```bash
    git clone <url-do-repositorio>
    cd backend
    ```

2.  Crie o arquivo de segredos:
    Crie um arquivo `application-secrets.properties` na raiz do projeto (`backend/`). Use o `backend/application-secrets.properties` como base, preenchendo as variáveis de ambiente do seu PostgreSQL e um segredo JWT:

    ```properties
    # Porta
    SERVER_PORT=8080

    # Banco de Dados
    DB_URL=jdbc:postgresql://localhost:5432/delivery
    DB_USER=postgres
    DB_PASS=seu_password_do_postgres

    # JWT
    JWT_SECRET=SeuSegredoMuitoForteParaGerarTokensJWTNaoCompartilhe

    # Google OAuth2 (Opcional, para login social)
    # GOOGLE_CLIENT_ID=seu_client_id
    # GOOGLE_CLIENT_SECRET=seu_client_secret
    ```

3.  Inicie o servidor de desenvolvimento:

    ```bash
    ./mvnw spring-boot:run
    ```

    (Ou `mvnw.cmd spring-boot:run` no Windows).

4.  A API estará em execução em `http://localhost:8080` (ou a porta definida em `application-secrets.properties`).

## Documentação da API (Swagger)

A documentação completa dos endpoints, incluindo modelos de requisição e resposta, é gerada automaticamente pelo SpringDoc (Swagger).

Após iniciar o servidor, a documentação interativa pode ser acessada em:

**`http://localhost:8080/swagger-ui.html`**

## Contribuição

Este projeto está em desenvolvimento ativo. Contribuições são bem-vindas\!

1.  Faça um fork do projeto
2.  Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3.  Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4.  Push para a branch (`git push origin feature/nova-feature`)
5.  Abra um Pull Request

## Licença

Este projeto está licenciado sob a licença MIT.

## Contato

Para suporte e dúvidas sobre o desenvolvimento, entre em contato através dos canais oficiais ou abra uma issue no repositório.
