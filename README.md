# Sentinela Mutation Testing - X-Men Project

Projeto Maven completo demonstrando a aplicação de **Testes de Mutação** com **Pitest**, **JUnit 5** e **Spring Boot**.

## 📁 Estrutura do Projeto

```
sentinela-mutation-testing/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── xmen/
    │               └── sentinela/
    │                   ├── domain/
    │                   │   ├── Alvo.java
    │                   │   ├── NivelAmeaca.java
    │                   │   ├── Sentinela.java
    │                   │   └── TipoAlvo.java
    │                   └── service/
    │                       └── SentinelaService.java
    └── test/
        └── java/
            └── com/
                └── xmen/
                    └── sentinela/
                        └── service/
                            ├── SentinelaServiceComBrechasTest.java
                            └── SentinelaServiceBlindadoTest.java
```

## 🚀 Como Executar

### 1. Rodar os testes unitários padrão:
```bash
mvn clean test
```

### 2. Rodar a análise de mutação com o Pitest:
```bash
mvn clean test pitest:mutationCoverage
```

### 3. Visualizar o Relatório em HTML:
Após a execução, abra o relatório no seu navegador preferido:
```
target/pit-reports/index.html
```
