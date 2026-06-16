# 📞 Agenda Telefônica em Java

Sistema de Agenda Telefônica desenvolvido em Java utilizando JDBC e MySQL para armazenamento dos contatos. O projeto permite realizar operações de cadastro, consulta, atualização e exclusão de contatos através de uma interface em modo console.

## 🎯 Objetivo

O objetivo deste projeto é aplicar conceitos de:

* Programação Orientada a Objetos (POO)
* Persistência de dados com MySQL
* JDBC (Java Database Connectivity)
* Padrão DAO (Data Access Object)
* Estruturação em camadas (Model, DAO, Factory e View)
* Operações CRUD (Create, Read, Update e Delete)

---

## 🛠 Tecnologias Utilizadas

* Java
* MySQL
* JDBC
* Eclipse IDE
* Git
* GitHub

---

## 📂 Estrutura do Projeto

```text
src
│
├── Factory
│   └── Conexao.java
│
├── Model
│   ├── Membro.java
│   │
│   └── Dao
│       └── MembroDao.java
│
└── View
    └── Agenda.java
```

---

## 📋 Funcionalidades

### ✅ Inserir contato

Permite cadastrar um novo contato informando:

* Nome
* Telefone
* E-mail

### ✅ Listar contatos

Exibe todos os contatos cadastrados no banco de dados.

### ✅ Atualizar contato

Permite alterar:

* Nome
* Telefone
* E-mail

de um contato já existente.

### ✅ Excluir contato

Remove um contato utilizando seu ID.

### ✅ Buscar contato por nome

Realiza a busca de contatos pelo nome informado.

---

## 🗄 Banco de Dados

### Criar o banco

```sql
CREATE DATABASE agenda;
```

### Selecionar o banco

```sql
USE agenda;
```

### Criar a tabela

```sql
CREATE TABLE membro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);
```

---

## ⚙ Configuração da Conexão

No arquivo:

```text
Factory/Conexao.java
```

Configure as credenciais do MySQL:

```java
String url = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
String usuario = "root";
String senha = "sua_senha";
```

Também é necessário adicionar o Driver JDBC do MySQL ao projeto.

---

## ▶ Como Executar

1. Criar o banco de dados e a tabela.
2. Configurar usuário e senha do MySQL.
3. Adicionar o Driver JDBC ao projeto.
4. Executar a classe:

```text
view.Agenda
```

5. Utilizar o menu interativo:

```text
1 - Inserir contato
2 - Excluir contato
3 - Atualizar contato
4 - Listar contatos salvos
5 - Buscar contato por nome
0 - Sair
```

---

## 📌 Exemplo de Uso

```text
--- CONTATOS ---

1 - Inserir contato
2 - Excluir contato
3 - Atualizar contato
4 - Listar contatos salvos
5 - Buscar contato por nome
0 - Sair
```

---

## 📚 Conceitos Aplicados

* Encapsulamento
* Classes e Objetos
* Conexão com Banco de Dados
* JDBC
* PreparedStatement
* ResultSet
* Tratamento de Exceções
* CRUD Completo
* DAO Pattern

---

## 👩‍💻 Autora

Isabella Fernandes

GitHub:
https://github.com/Isapfernandes

---

## 📄 Licença

Projeto desenvolvido para fins acadêmicos e educacionais.
