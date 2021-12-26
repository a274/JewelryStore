# Spring Boot приложение на тему "Ювелирные украшения"
СУБД - PostgreSQL  
Реализуются:  
+ Регистрация пользователей;  
+ Разные права доступа - пользователь/администартор;  
+ Почтовый сервис;  
+ Фильтрация товаров;  
+ Изменение данных в панели администратора;
+ Корзина пользователя.

Используемые технологии:
+ PostgreSQL;
+ Maven;
+ REST;
+ Spring MVC;  
+ Spring Data JPA;  
+ Spring Security;  
+ ORM;  
+ JUnit, Mockito.  

Для запуска приложения необходимо указать  
+ адрес и пароль от базы данных в файле application.properties;  
+ почтовый адрес в поле email и пароль в поле password в классе services/EmailService;
+ почтовый адрес в поле email в классе controllers/UserController.