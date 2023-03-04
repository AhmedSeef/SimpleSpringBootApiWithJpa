# SimpleSpringBootApiWithJpa

simple spring boot rest api with jpa repository and my sql server

## Steps to install

**1. Clone the application**

```bash
git clone https://github.com/AhmedSeef/SimpleSpringBootApiWithJpa.git
```

**2. Create MySQL database**

```sql
CREATE DATABASE demo
```

**3. Create table or Run the SQL script file**

```sql
CREATE TABLE Contact
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    	firstName VARCHAR(255),
    	lastName VARCHAR(255),
    	email VARCHAR(255)
)
```

**4. Change MySQL Username and Password as per your MySQL Installation**

- open `src/main/resources/application.properties` file.

- change `spring.datasource.username` and `spring.datasource.password` as per your installation

**5. Run the app**

You can run the spring boot app by typing the following command -

```bash
mvn spring-boot:run
```

You can also package the application in the form of a `jar` file and then run it like so -

```bash
mvn package
java -jar target/crudapi-0.0.1-SNAPSHOT.jar
```

The server will start on port 8080.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/Contact/getAll

    GET /api/Contact/getOne/{id}

    POST /api/Contact

    PUT /api/Contact

    DELETE /api/Contact/{id}

You can test them using postman or any other rest client.
