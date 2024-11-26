
# GraphQL API with Spring Boot

This project demonstrates how to build a GraphQL API using Spring Boot, JPA, and MySQL.

## Steps to Set Up

1. Create a Spring Boot Project
   Use [Spring Initializr](https://start.spring.io/) and add dependencies:
   - `spring-boot-starter-data-jpa`
   - `spring-boot-starter-graphql`
   - `spring-boot-starter-web`
   - `mysql-connector-j`

2. Define Entities
   Create `User` and `Order` entities with JPA annotations.

3. Create Repositories  
   Use `JpaRepository` to manage entities:
   ```java
   public interface UserRepository extends JpaRepository<User, Long> {}
   public interface OrderRepository extends JpaRepository<Order, Long> {}
   ```

4. Implement Services 
   Add business logic in service classes like `UserService`.

5. Add GraphQL Controllers 
   Use `@QueryMapping` and `@MutationMapping` annotations in `UserController`.

6. Define Schema  
   Add `schema.graphqls` in `src/main/resources`:
   ```graphql
   type Query {
       getUsers: [User]
       getUser(userId: ID!): User
   }
   type Mutation {
       createUser(name: String, email: String, password: String): User
       deleteUser(userId: ID!): Boolean
   }
   ```

7. Configure Application 
   Enable GraphQL UI in `application.properties`:
   ```properties
   spring.graphql.graphiql.enabled=true
   ```

8. Run and Test
   - Start the application: `mvn spring-boot:run`.
   - Test GraphQL queries at `/graphiql`.

## Example GraphQL Queries
- Get All Users:
  ```graphql
  query {
      getUsers {
          userId
          name
          email
      }
  }
  ```
- Create a User:
  ```graphql
  mutation {
      createUser(name: "John Doe", email: "john@example.com", password: "password123") {
          userId
          name
      }
  }
  ```
