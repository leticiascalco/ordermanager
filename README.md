
# OrderManager

OrderManager é uma aplicação de gerenciamento de pedidos projetada para processar e gerenciar pedidos de maneira eficiente. O projeto é desenvolvido utilizando Kotlin, Spring Boot e Kafka, e utiliza DynamoDB para garantir a idempotência dos processos.

## Funcionalidades

- ✅ **Consumo de Eventos Kafka**: A aplicação consome eventos em batch a partir de tópicos Kafka.
- ⏳ **Processamento Paralelo**: Processa eventos em paralelo para maior eficiência.
- ✅ **Idempotência Garantida**: Utiliza DynamoDB para garantir que cada evento seja processado apenas uma vez.
- ✅ **Produção de Eventos Kafka**: Produz eventos para tópicos Kafka após o processamento.
- ✅ **Arquitetura Hexagonal**: Segue o padrão de arquitetura hexagonal para modularidade e facilidade de manutenção.
- ⏳ **Logging e Métricas**: Implementa logging estruturado e métricas utilizando Micrometer e Prometheus.
- ⏳ **Infraestrutura como Código**: Utiliza Terraform para configurar a infraestrutura na AWS.
- ⏳ **Testes**: Inclui testes unitários e de integração para garantir a qualidade do código.

## Tecnologias

- **Linguagem**: Kotlin
- **Framework**: Spring Boot 3+
- **Mensageria**: Kafka
- **Banco de Dados**: DynamoDB
- **Infraestrutura**: AWS, Terraform
- **Logging e Métricas**: Micrometer, Prometheus
- **Docker**: Docker-compose para execução local
- **Pipeline**: AWS CodePipeline, CodeBuild e GitHub Actions

## Instalação

1. Clone o repositório:

   ```bash
   git clone git@github.com:leticiascalco/ordermanager.git
