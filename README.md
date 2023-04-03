## Event Management App
The admin determines in which city the events will take place.\
Admin can create city and also add an event to particular city.\
Admin is authorized  all request.\

Regular user can create just event.\
Each city may have multiple events and can be changeable.\

serhat and zeynep are standard user that they can see everything and add events, but have no authority to add new city.

## Technologies

Java 17, Spring Boot 3, Spring Security 6, JWT, PostgreSQL, Lombok, Spring Data JPA ( Hibernate), Tomcat, Postman, Intellij IDEA


## Project Structure

<ul>
  <li>config</li>
   <li>controller</li>
  <li>dto</li>
  <li>entity</li>
  <li>exception</li>
  <li>mapper </li>
<li>model </li>
  <li>repository</li>
<li>security</li>
  <li>service</li>
  <li>payload</li>

</ul>

## Authorization
| Username | Password |
|----------|----------|
| admin    | admin    |
| zeynep   | zeynep   |
| serhat   | serhat   |



| Type  | Method |
|-------| ------ |
| POST | http://localhost:8080/api/auth/register |

```
{
    "name":"zeynep",
    "username":"zeynep",
    "email":"zeynep@gmail.com",
    "password":"zeynep"
}
```

| Type  | Method |
|-------| ------ |
| POST | http://localhost:8080/api/auth/signin |

```
{
    "usernameOrEmail":"zeynep@gmail.com",
    "password":"zeynep"
}
```