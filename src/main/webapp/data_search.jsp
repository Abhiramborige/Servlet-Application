<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styling/style.css">
    <title>Login Page</title>
</head>

<body>
    <h1>Login Form</h1>
    <% 
        // this makes the previous page out of the cached pages.
        response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
        
        String username=(String) session.getAttribute("Username");
        // before asking for credentials, check the session.
        if(username!=null){
            session.setAttribute("Username", username);
            response.sendRedirect("home_user.jsp");
            return;
        }
        else{
            System.out.println("Login page(session): "+username);
        }

        // check for any cookies.
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("Username")){
                    username = cookie.getValue();
                    System.out.println("Login page(cookie): "+username);
                    break;
                }
            }
        }
        if(username!=null){
            response.sendRedirect("home_user.jsp");
            // https://stackoverflow.com/questions/2123514/java-lang-illegalstateexception-cannot-forward-sendredirect-create-session
            return;
        }
    %>
    <form action="./success" method="POST">
        <label for="Username">Enter Username: </label>
        <input type="text" name="Username" id="Username" autocomplete="off"><br><br>
        <label for="Password">Enter Password: </label>
        <input type="password" name="Password" id="Password"><br><br>
        <input type="submit" value="Login Using HttpSession" name="button">
        <input type="submit" value="Login Using Cookies" name="button">
    </form>
</body>