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

## Must do things after cloning:
1. In database.java, update line no. 18 with the password of your MySQL database server.
2. In view.jsp, update line no. 20 with the password of your MySQL database server.
3. Then run using mvn commands (mvn clean, and then mvn package)

*** 
## Video for reference:
[![IMAGE ALT TEXT HERE](http://img.youtube.com/vi/L7iKSmuuNuw/0.jpg)](http://www.youtube.com/watch?v=L7iKSmuuNuw)https://youtu.be/T33X5lPYWS4
<iframe width="560" height="315" src="https://www.youtube.com/embed/T33X5lPYWS4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


### Hope it helps! 👍🙂
