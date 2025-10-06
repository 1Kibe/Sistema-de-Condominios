# Sistema de Condomínio

Este projeto tem como objetivo facilitar a gestão de condomínios, permitindo o cadastro e administração de moradores, funcionários, áreas comuns, reservas, reuniões e visitas.

## Funcionalidades

- Cadastro de moradores, funcionários e visitantes
- Gerenciamento de áreas comuns e reservas
- Controle de reuniões e regras do condomínio
- Registro de visitas e penalidades
- Estrutura flexível para diferentes tipos de condomínios

## Estrutura do Projeto

```
src/
  main/
    java/
      com/
        ryan/
          condominosys/
            CondominosysApplication.java
            domain/
            repository/
            resource/
            service/
  resources/
    application.properties
    db/
      migration/
    static/
    templates/
test/
  java/
    com/
      ryan/
        condominosys/
          CondominosysApplicationTests.java
Diagramas/
  *.drawio
```

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- Banco de dados relacional (configurável)
- Diagramas Draw.io

## Como Executar

1. Clone o repositório:
   ```
   git clone https://github.com/seu-usuario/SistemaDeCondominio.git
   ```
2. Acesse a pasta do projeto:
   ```
   cd SistemaDeCondominio/condominosys
   ```
3. Configure o banco de dados em `src/resources/application.properties`.
4. Execute a aplicação:
   ```
   mvn spring-boot:run
   ```

## Diagramas

Os diagramas do sistema estão disponíveis na pasta `Diagramas/` e podem ser abertos com o [Draw.io](https://app.diagrams.net/).


## Aviso

**Este é um projeto de estudo e pode conter erros.**
