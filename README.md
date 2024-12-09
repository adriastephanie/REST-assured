# Automação de API REST

Este documento é a criação de uma automação de API, que utiliza RestAssured e JUnit como framework de testes de API.

- [Java](https://www.oracle.com/br/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [JUnit5](https://junit.org/junit5/)
- [Rest-assured](https://rest-assured.io/)
- [Allure](https://allurereport.org/)

## Configuração local

Java
1- Baixar o Java;
2- Extrair o conteúdo baixado em um local do disco;
3- Configurar na variável (Path) de ambiente do sistema o caminho do seu Sistema Operacional

Comando verifica se está instalado o Java
```sh
java --version
```
O resultado será assim:
```sh
adriastephanie@MacBook-Pro-de-Adria ~ % java --version
java 21.0.1 2023-10-17 LTS
Java(TM) SE Runtime Environment (build 21.0.1+12-LTS-29)
Java HotSpot(TM) 64-Bit Server VM (build 21.0.1+12-LTS-29, mixed mode, sharing)
```

Maven
1- Baixar o maven;
2- Extrair o conteúdo baixado em um local do disco;
3- Configurar na variável (Path) de ambiente do sistema o caminho do seu Sistema Operacional

Comando verifica se está instalado o maven
```sh
mvn -v  
```

O resultado será assim:

```sh
adriastephanie@MacBook-Pro-de-Adria ~ % mvn -v
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /usr/local/Cellar/maven/3.9.9/libexec
Java version: 23.0.1, vendor: Homebrew, runtime: /usr/local/Cellar/openjdk/23.0.1/libexec/openjdk.jdk/Contents/Home
Default locale: pt_BR, platform encoding: UTF-8
OS name: "mac os x", version: "15.1.1", arch: "x86_64", family: "mac"
```

## Configuração Inicial do Projeto

Com a IDE, o Java e o Maven instalados e configurados podemos criar um projeto Maven. No IntelliJ é só usar o caminho pelo caminho File > New > Project > Maven
A própria IDE irá cria, atualizar as dependência necessárias e apresentar o projeto com a estrutura básica no painel com um main pronto para uso.

O maven utiliza o arquivo pom.xml para controlar as dependências, então é necessário adicionar rest-assured e o junit e atualizar as dependencias do projeto para instalar e ser reconhecida na IDE/projeto.

Foi Adicionado no pom.xml as dependências manualmente para configurar o projeto. Ao adicionar as dependências, é necessário sincronizar o arquivo para ele processar e o projeto atualizar as dependências.

## Como executar o projeto

```sh
# Clone este repositório
git clone https://github.com/adriastephanie/REST-assured.git

# Acesse a pasta do projeto e execute os comandos a seguir
mvn clean install -U
```
## Testes Dog API

Documentação: https://dog.ceo/dog-api/documentation

**Endpoints a serem testados:**
- `GET /breeds/list/all`
- `GET /breed/{breed}/images`
- `GET /breeds/image/random`

## Executando os testes

ATENÇÃO:
Existe duas branchs, uma com cucumber e outra sem, foi feita duas estruturas.

### Executando os testes sem cucumber 

```sh
mvn test 
```

O CI está rodando e está guardando os relatórios do Allure, basta escolher qual vc quer ver lá mesmo no Actions.


