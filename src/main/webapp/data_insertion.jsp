<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Data Insertion Form</title>
    <link rel="stylesheet" href="./styling/style.css">
</head>

<body>
    <h1>Data Insertion Form</h1>
    <form action="./view.jsp" method="POST">
      <input type="submit" value="Click to see all data in the table"><br><br>
    </form>
    <% 
        String username=(String) session.getAttribute("Username");
        // before asking for credentials, check the session.
        if(username!=null){
            session.setAttribute("Username", username);
            response.sendRedirect("home_user.jsp");
            return;
        }
        else{
            System.out.println("Register page(session): "+username);
        }

        // check for any cookies.
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("Username")){
                    username = cookie.getValue();
                    System.out.println("Register page(cookie): "+username);
                    break;
                }
            }
        }
        if(username!=null){
            response.sendRedirect("home_user.jsp");
            return;
        }
    %>
    <form action="./success" method="POST">
        <label for="Username">Username: </label>
        <input type="text" name="Username" id="Username" autocomplete="off"><br><br>
        <label for="Password">Password: </label>
        <input type="password" name="Password" id="Password"><br><br>
        <label for="date_of_birth">Date of Birth</label>
        <input type="date" name="date_of_birth" id="date_of_birth"><br><br>
        <input type="submit" value="Register" name="button">
    </form>
</body>
