# Java Web Application
* Developed using Maven
* Uses Apache TomCat for deployment and testing
* Worked in Microsoft VS Code 

*** 
## Includes:
1.  Basic Servlet concepts
    * Servlet API (classes and interfaces)
    * Servlet Interface and class methods
    * Generic ServletRequest methods
    * HttpServletRequest methods
    * Generic ServletResponse methods
    * HttpServletResponse methods
    * RequestDispatcher interface
    * sendRedirect() method
    * ServletConfig interface
    * ServletContext interface
    * COntext and Init parameters
    * Attribute Objects
2. Basic JSP concepts:
    * JSP Tags
    * JSP Directives
3. Maven Dependencies:
    * junit
    * javax.servlet-api
    * mysql-connector-java
4. JDBC and MySQL concepts:
    * Connection via driver
    * ResultSet, Statement
    * Creation 
    ```mysql
    CREATE DATABASE servlet_application ;
    CREATE TABLE store_user(
    Username varchar(30) NOT NULL PRIMARY KEY,
    Password varchar(30) NOT NULL,
    date_of_birth date NOT NULL,
    date_register timestamp NOT NULL);
    ```
    * Registration (Insertion operation)
    ```mysql
    INSERT INTO store_user VALUES
    (NULLIF(Username,''), 
    NULLIF(Password,''), 
    NULLIF(date_of_birth,''), 
    date_register);
    ```
    * Authentication (Selection operation)
    ```mysql
    SELECT * FROM store_user WHERE Username="username";
    SELECT * FROM store_user WHERE Username="username" AND Password="password";
    ```
    * Deletion (Dropping row)
    ```mysql
    DELETE FROM store_user WHERE Username="username";
    ```
    * Updating Passowrd (Update row)
    ```mysql
    UPDATE store_user SET password="newPassword"
    WHERE username="username" AND password="oldPassword";
    ```
    
5. Other concepts:
    * Conditional statements
    * Looping
    * Styling with css
    * Exceptional handling
    * Modular programming
    * Erros/Exceptional Handling
    * Packages
    * HTML rendering
    * XML modifications.
6. Many more coming soon. Contributions are welcomed. Must integrate with the project, but not make it as seperate project. 

*** 
## Video for reference:
<div align="center">
   <a href="https://youtu.be/T33X5lPYWS4" target="_blank" rel="noopener noreferrer">
      <img src="http://img.youtube.com/vi/T33X5lPYWS4/0.jpg" height="200px" width="250px">
   </a>
   <a href="https://youtu.be/4QQ3e1vVwdU" target="_blank" rel="noopener noreferrer">
      <img src="http://img.youtube.com/vi/4QQ3e1vVwdU/0.jpg" height="200px" width="250px">
   </a>
   <a href="https://youtu.be/mbE3nve0G90" target="_blank" rel="noopener noreferrer">
      <img src="http://img.youtube.com/vi/mbE3nve0G90/0.jpg" height="200px" width="250px">
   </a>
   <a href="https://youtu.be/cuscNGMMtfs" target="_blank" rel="noopener noreferrer">
      <img src="http://img.youtube.com/vi/cuscNGMMtfs/0.jpg" height="200px" width="250px">
   </a>
</div>

***
## Must do things after cloning:
1. In database.java, update line no. 18 with the password of your MySQL database server.
2. In view.jsp, update line no. 20 with the password of your MySQL database server.
3. Then run using mvn commands (mvn clean, and then mvn package)

### Hope it helps! 👍🙂
