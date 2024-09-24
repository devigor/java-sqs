# Java SQS

Um simples projeto para construir uma API que irá enviar um evento a uma fila SQS e outra API para consumir essa fila e salvar no banco de dados.
Foi utilizado LocalStack para reproduzir uma fila SQS localmente, OpenTofu para fazer a infra da fila e Docker para levantar um container do LocalStack e outro para o bando de dados PostgreSQL.
## Stack

- Java 21
- Spring 3.3.4
- Spring Cloud
- LocalStack (para ter a fila localmente)
-  AWS SQS
- OpenTofu
- Docker
- PostgreSQL
## Instalação

```bash
git clone https://github.com/devigor/java-sqs
cd java-sqs
sh start-dev.sh
```