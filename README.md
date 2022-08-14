# Common Tool for daily usage


## 1. Project Description
This is a simple rest service project to deal with various common need, something like:
- url 
  - alias
  - shortner
- pdf
  - merge, split, etc...
- image
  - Extract text
- Etc ...

> This tool intended to make life easier.

<br/>

## 2. Design

### 2.1 Things to know

Besides daily usage, this project is also a learning-project.
Which is means that this project is build with these "things" in mind:

- Clean code
- 12 Factor App
- Securing rest api
- More to comes....


### Tech stack used in this project

- Java (18)
- Spring boot
    - Hibernate
    - Security (Jwt)
- JUnit
- JSON
- Springdoc & Swagger-UI
- SQL (PostgreSQL)
- Docker

From docker container, we can deploy it to cloud hosting provider line AWS ECS, etc...

## 3. Getting Started

To install and run this module, you need
- Git
- Java (from 11)
- Maven
- Docker
- A running PostgreSQL Instance


And do following steps:

1. Fork or just clone this repo.
2. open terminal and change to project main directory
3. compile the project, it will produce JAR file
```bash
$ mvn clean package
```
4. Containerize the project
```bash
$ docker build -f Dockerfile -t url-tool .
```
5. Check if the image already on list
```bash
$ docker image ls
```
6. Then we can run the image
```bash
$ docker run --name url-tool-test -e SPRING_DATASOURCE_URL='database_url' -e SPRING_DATASOURCE_USERNAME='database_user_name' -e SPRING_DATASOURCE_PASSWORD='database_password' -p 8080:8080 url-tool
```
<br>

As you can see on command, there is some environment  (-e) that we need to give.

- **SPRING_DATASOURCE_URL**
    - A running PostgreSQL database instance url
        - For example : jdbc:postgresql://localhost:5432/tool
        - Dont forget to add *jdbc:postgresql:* before the url

- **SPRING_DATASOURCE_USERNAME**
    - Username that is used to login to database
- **SPRING_DATASOURCE_PASSWORD**
    - Password that is used to login to database
- **SERVICE_IDENTIFIER**
    - Custom value(string) to identify the service in runtime
    - Default value is "none"
- **APP_JWTSECRETKEY**
  - some string that will be used to generate & validate jwt token






























