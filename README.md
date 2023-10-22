# Santander Dev Week

Java RESTful API criada para a Santander Dev Week

## Ferramentas utilizadas

JDK 17
Lombok
MySQL
FlyWay
Springboot

## Railway

Link de produção: https://santander-dev-week-2023-production-e189.up.railway.app/

## Diagrama de Classes

``` mermaid

classDiagram
    class User {
        - String name
        - Account account
        - List<Feature> features
        - Card card
        - List<News> news
    }

    class Account {
        - String number
        - String agency
        - double balance
        - double limit
    }

    class Feature {
        - String icon
        - String description
    }

    class Card {
        - String number
        - double limit
    }

    class News {
        - String icon
        - String description
    }

    User "1" -- "1" Account
    User "1" -- "n" Feature
    User "1" -- "1" Card
    User "1" -- "n" News

