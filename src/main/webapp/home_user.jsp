
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home!</title>
    <link rel="stylesheet" href="./styling/style.css">
</head>


<% 
    // making for a perfect Logout functionality.
    // this makes the previous page out of the cached pages.
    // https://stackoverflow.com/questions/3976624/java-servlet-how-to-disable-caching-of-page
    response.setHeader("Cache-control","private, no-cache, no-store, must-revalidate");
    response.setHeader("Pragma","no-cache"); 

    String username=(String) session.getAttribute("Username");
    if(username!=null){
        System.out.println("Home page(session): "+username);
    }
    else if(username==null){
        // if no session, then check for cookies
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("Username")){
                    username = cookie.getValue();
                }
            }
            System.out.println("Home page(cookie): "+username);
            if(username==null){
                response.sendRedirect("data_search.jsp");
            }
        }
        else{
            response.sendRedirect("data_search.jsp");
        }
    }
%>

<h2>Login Page, <br> Successful Login</h2>
<p>Welcome <%= username %></p>

<form action="./success" method="POST">
    <input type='hidden' name="old_username" value="<%= username %>">
    Old Password: <input type='password' name="old_password">
    New Password: <input type='password' name="new_password">  
    Confirm new password: <input type='password' name="confirm_new_password">
    <input type='submit' value="Update password" name="button">
    <br/>
    <input type='submit' value='Logout' name="button">
</form>