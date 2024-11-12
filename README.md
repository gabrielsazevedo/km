# Sistema de Compartilhamento de Conhecimento

## 📝 Sobre o Projeto
Sistema web desenvolvido em Spring Boot para facilitar o compartilhamento de conhecimento tácito dentro de organizações através de vídeos. Permite que funcionários compartilhem suas experiências e conhecimentos através de uploads de vídeos, que podem ser consultados e comentados por outros membros da organização.

## 🚀 Funcionalidades

### Principais recursos:
- Upload de vídeos com título e descrição
- Consulta de vídeos por título
- Visualização de vídeos
- Sistema de comentários (sem necessidade de login)
- Interface responsiva e amigável

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot 3.1.5
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- HTML5
- CSS3
- Maven
- Lombok

## 📋 Pré-requisitos

- JDK 21 ou superior
- Maven 3.6 ou superior
- PostgreSQL 12 ou superior
- IDE de sua preferência

## 🔧 Configuração do Ambiente

### 1. Banco de Dados
```sql
CREATE DATABASE knowledge_db;
```

### 2. Configuração do application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/knowledge_db
spring.datasource.username=postgres
spring.datasource.password=postgres
```

### 3. Estrutura de Diretórios
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── knowledge/
│   │           ├── controller/
│   │           ├── model/
│   │           ├── repository/
│   │           └── service/
│   └── resources/
│       ├── static/
│       │   └── css/
│       │       └── style.css
│       └── templates/
│           ├── index.html
│           └── video.html
```

## 💻 Como Executar

1. Clone o repositório:
```bash
git clone [url-do-repositorio]
```

2. Entre no diretório do projeto:
```bash
cd knowledge-sharing
```

3. Compile o projeto:
```bash
mvn clean install
```

4. Execute a aplicação:
```bash
mvn spring-boot:run
```

5. Acesse no navegador:
```
http://localhost:8080
```

## 📦 Estrutura do Projeto

### Modelos (Model)
- `Video`: Entidade que representa os vídeos uploadados
- `Comment`: Entidade que representa os comentários

### Controladores (Controller)
- `VideoController`: Gerencia operações relacionadas a vídeos
- `CommentController`: Gerencia operações relacionadas a comentários

### Serviços (Service)
- `VideoService`: Lógica de negócio para operações com vídeos
- `CommentService`: Lógica de negócio para operações com comentários

### Repositórios (Repository)
- `VideoRepository`: Interface para operações de banco de dados com vídeos
- `CommentRepository`: Interface para operações de banco de dados com comentários

## 🔍 Endpoints da API

### Vídeos
- `GET /`: Página inicial com lista de vídeos
- `POST /upload`: Upload de novo vídeo
- `GET /video/{id}`: Visualização de vídeo específico
- `GET /video/{id}/data`: Stream do arquivo de vídeo

### Comentários
- `POST /video/{id}/comment`: Adicionar comentário a um vídeo

## ⚙️ Configurações Adicionais

### Configuração de Upload
O sistema está configurado para aceitar arquivos de até 100MB:
```properties
spring.servlet.multipart.max-file-size=100MB
spring.servlet.multipart.max-request-size=100MB
```

### Configurações de JPA
```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🔒 Segurança
- O sistema atualmente não requer autenticação
- Implementação de segurança pode ser adicionada conforme necessidade
- Recomenda-se adicionar validação de tipos de arquivo permitidos

## 🔄 Próximos Passos
- Implementação de autenticação de usuários
- Sistema de categorização de vídeos
- Busca avançada com filtros
- Sistema de likes/dislikes
- Geração de thumbnails para os vídeos
- Compressão de vídeos


## ✒️ Autores
Gabriel Azevedo - @gabrielsazevedo(https://github.com/gabrielsazevedo)
