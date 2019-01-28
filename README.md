# Bravi Desafio JAVA

Este projeto tem como objetivo a implementação do teste para a empresa [Bravi Softwares](https://www.bravi.com.br/) cujo os desafios são:

1. Baleanciamento de Colchetes

   - Escrever uma função que use uma string de colchetes como entrada e determine se a ordem de os parênteses são válidos. Um bracket é considerado qualquer um dos seguintes caracteres: ( ), { }, ou [ ].

2. Lista de Contatos
   - Criar uma API REST que armazene pessoas e seus contatos. Uma pessoa pode ter múltiplos contatos como telefone, e-mail ou whatsapp. A API deve permitir criar, atualizar, obter e apague as pessoas e os contatos.

Este projeto utiliza as tecnologias:

- [Spring Framework](https://spring.io/) version 5.1.4
- [Spring Boot](https://spring.io/) version 2.1.2
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) version 2.1.2
- [H2 Database](https://getbootstrap.com) version 1.4.197

## Guia de uso

Para usufruir da aplicação é necessário ter a ferramenta [Postman](https://www.getpostman.com/) ou [Insomnia](https://insomnia.rest), com elas você poderá enviar requisições HTTP para os endpoints da API que estão detalhados logo a baixo.

### Registrar pessoa

- Enviar uma requisicação HTTP para o endpoint `/api/people` no metodo POST com a seguinte estrutura em seu corpo:

```
    {
        "name": "Matheus Costa"
    }
```

- Exmplo de resposta:

```
    {
        "id": 1,
        "name": "Matheus Costa",
        "contacts": null
    }
```

NOTA: Para editar as informações de uma pessoa basta passar o atributo `id` na requisição e os novos valores.

### Listar pessoas

- Enviar uma requisicação HTTP para o endpoint `/api/people` no metodo GET. Exmplo de resposta:

```
    [
        {
            "id": 1,
            "name": "Matheus Costa",
            "contacts": [
                {
                    "id": 1,
                    "typeContact": "WhatsApp",
                    "valueContact": "(66) 99611-5591"
                }
            ]
        }
    ]
```

### Excluir pessoa

- Enviar uma requisicação HTTP para o endpoint `/api/people/{idPeople}` no metodo DELETE. Exmplo de resposta:

```
    true
```

NOTA: Ao excluir uma pessoa todos os contatos pertencetes a esta pessoa serão excluidos também.

### Novo contato

- Enviar uma requisicação HTTP para o endpoint `/api/contact/{idPeople}` no metodo POST com a seguinte estrutura em seu corpo:

```
    {
        "typeContact": "WhatsApp",
        "valueContact": "66 99611-5591"
    }
```

- Exmplo de resposta:

```
    {
        "id": 1,
        "typeContact": "WhatsApp",
        "valueContact": "66 99611-5591"
    }
```

NOTA: Para editar as informações de contato basta passar o atributo `id` na requisição e os novos valores.

### Listar contatos

- Enviar uma requisicação HTTP para o endpoint `/api/contact/{idPeople}` no metodo GET. Exmplo de resposta:

```
    [
        {
            "id": 1,
            "typeContact": "WhatsApp",
            "valueContact": "(66) 99611-5591"
        }
    ]
```

### Excluir contato

- Enviar uma requisicação HTTP para o endpoint `/api/contact/{idContact}` no metodo DELETE. Exmplo de resposta:

```
    true
```

## Implantação

Para que este projeto seja executado é necessário que tenha instalado na máquina ou VM os seguintes recursos:

- [JAVA JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) version 1.8
- [Eclipse IDE](https://www.eclipse.org/)

## Servidor local

Para rodar a aplicação em ambiente local, importe ela na IDE eclipse, abra o arquivo `BraviApplication.java` e execute o metodo main como `Java Application`. Agora basta enviar suas requisições HTTP para o domínio `http://localhost:9000/`.

## Baleanciamento de Colchetes

Para rodar a função de baleanciamento de colchetes, importe a apicação na IDE eclipse, abra o arquivo `BalancedBrackts.java` e execute o metodo main como `Java Application`. Agora basta acompanhar os resultados no console.

## Help

Caso necessite de ajuda para implantação você pode enviar um email para [mcostap80@gmail.com](mailto://mcosta80@gmail.com).
