<h1>Produto MS CRUD</h1>

Microsserviço de gerenciamento de produtos desenvolvido em Spring Boot e Java.

<h2>Sumario</h2>

- [Sobre](#sobre)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação](#instalacao)
- [Uso](#uso)
- [Testando o Aplicativo](#testando-o-aplicativo)
- [Contribuições](#contribuicoes)
- [Contato](#contato)

<h2 id="sobre">Sobre</h2>

O Produto MS CRUD é um microsserviço que fornece uma API RESTful para gerenciar produtos. Foi desenvolvido utilizando Spring Boot e Java.

<h2 id="funcionalidades">Funcionalidades</h2>

- CRUD (Create, Read, Update, Delete) de produtos
- API RESTful para interação com o microsserviço

<h2 id="tecnologias-utilizadas">Tecnologias Utilizadas</h2>

- Spring Boot
- Java 17
- Lombok
- H2 Database
- Maven

<h2 id="instalacao">Instalação</h2>

1. Clonar o repositório
2. Executar o comando `mvn spring-boot:run` para iniciar o aplicativo

<h2 id="uso">Uso</h2>

Acessar a API através do endpoint http://localhost:8080/api/produtos

<h2 id="testando-o-aplicativo">Testando o Aplicativo</h2>

Para testar o aplicativo, você pode utilizar as seguintes URLs:

<h3>Produto</h3>

- [Listar todos os produtos:](#listar-todos) `http://localhost:8080/api/produtos`
- [Buscar produto por ID:](#buscar-por-id) `http://localhost:8080/api/produtos/{id}`
- [Criar novo produto:](#criar) `http://localhost:8080/api/produtos` (método POST)
- [Atualizar produto:](#atualizar) `http://localhost:8080/api/produtos/{id}` (método PUT)
- [Deletar produto:](#deletar) `http://localhost:8080/api/produtos/{id}` (método DELETE)

<h4>Exemplo de Request/Response</h4>

- <h5 id="listar-todos">Listar todos os produtos:</h5>

  - Request: `GET http://localhost:8080/api/produtos`

  - Response: `[{"id": 1,"nome": "Produto 1","preco": 10.99}, 
{"id": 2,"nome": "Produto 2","preco": 9.99 }]`

- <h5 id="buscar-por-id">Buscar produto por ID</h5>

  - Request: `GET http://localhost:8080/api/produtos/{id}`

  - Response: `{"id": 1,"nome": "Produto 1","preco": 10.99 }`
    
  **Lembre-se de substituir `{id}` pelo ID do produto que você deseja testar.**

- <h5 id="criar">Criar novo produto</h5>

  - Request: `POST http://localhost:8080/api/produtos`
    - Body: `{"nome": "Novo Produto","preco": 12.99 }`

  - Response: `{"id": 3,"nome": "Novo Produto","preco": 12.99}`

- <h5 id="atualizar">Atualizar produto</h5>

  - Request: `PUT http://localhost:8080/api/produtos/{id}`
    - Body: `{"nome": "Produto Atualizado","preco": 11.99 }`

  - Response: `{"id": 1,"nome": "Produto Atualizado","preco": 11.99 }`
  
  **Lembre-se de substituir `{id}` pelo ID do produto que você deseja testar.**


- <h5 id="deletar">Deletar produto</h5>

  - Request: `DELETE http://localhost:8080/api/produtos/{id}`
  - Response:`{"mensagem": "Produto deletado com sucesso"}`

  **Lembre-se de substituir `{id}` pelo ID do produto que você deseja testar.**

<h2 id="contribuicoes">Contribuições</h2>

Contribuições são bem-vindas! Se você encontrar algum bug ou tiver sugestões de melhoria, por favor, abra uma issue ou envie um pull request.

<h2 id="contato">Contato</h2>

Carolina Bartoli 
- carolina.bartoli01@gmail.com
- https://www.linkedin.com/in/carolinabartoli/