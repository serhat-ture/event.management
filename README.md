## Event Management App
The admin determines in which city the events will take place.\
Admin can create city and also add an event to particular city.\
Admin is authorized  all request.

Regular user can create just event.\
Each city may have multiple events and can be changeable.

serhat and zeynep are standard user that they can see everything and add events, but have no authority to add/delete/update new city.

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
register new user
<img width="1019" alt="Screenshot 2023-04-03 at 13 28 31" src="https://user-images.githubusercontent.com/67038603/229497784-5bd6acce-54c4-4479-b7e9-f1413665936d.png">

user zeynep added database
<img width="824" alt="Screenshot 2023-04-03 at 13 29 07" src="https://user-images.githubusercontent.com/67038603/229498251-63f884c8-147c-44f3-99df-da7de161d28a.png">

login and get JWT token
<img width="1006" alt="login user" src="https://user-images.githubusercontent.com/67038603/229498963-59388636-ad55-4c55-8545-0e107bdf53c2.png">

zeynep - get request
<img width="1008" alt="user get request" src="https://user-images.githubusercontent.com/67038603/229499871-dd30bf77-1da8-40dc-baaf-c602ae5b448a.png">

zeynep - post request for city ( admin authorized)
<img width="1036" alt="user try post for city" src="https://user-images.githubusercontent.com/67038603/229500491-ae08f967-63fc-4720-aa28-8f3368395e45.png">
 
zeynep - post request for event (authorized)
<img width="1047" alt="user create event" src="https://user-images.githubusercontent.com/67038603/229501455-db085bda-b243-46e0-b8ec-db28cf3cd8ce.png">

new event was added in database
<img width="1202" alt="new event" src="https://user-images.githubusercontent.com/67038603/229502245-5e0cf29e-f8ff-491a-ac6a-931ac5ee5ba0.png">

