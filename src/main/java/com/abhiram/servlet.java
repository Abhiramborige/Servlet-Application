package com.abhiram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {

    private static final long serialVersionUID = 2161581691453946987L;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* Usage of some methods in HttpServletResponse and ServletResponse interfaces */
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String cssTag="<link rel='stylesheet' type='text/css' href='./styling/style.css'>";
        out.println("<head><title>Servlet Home Page</title>"+cssTag+"</head>");
        out.println("<body>");
        try{
            if(request.getParameter("user")==""){
                /* Dispatching the request to server.java servlet */
                RequestDispatcher rd=request.getRequestDispatcher("index.html");
                // forward the request and response
                rd.include(request, response);
                out.println("<h3> Enter a valid name </h3>");
                /* ServletContext interface application */
                ServletContext sc=getServletConfig().getServletContext();
                /* These are available to any servlet or JSPs that are part of the web app. */
                out.println("<p>Visit my <a href='"+sc.getInitParameter("MyWebsite")+"'> Webpage</a> to checkout more!😃✌</p>");

            }
            else if(request.getParameter("ADMIN_Dispatcher")!=null){
                /* Dispatching the request to admin.java servlet */
                RequestDispatcher rd=request.getRequestDispatcher("/admin_api");
                // forward the request and response
                rd.forward(request, response);
            }
            else if(request.getParameter("ADMIN_Redirect")!=null){
                /* The main difference between a redirection and a request dispatching is that, 
                redirection makes the client(browser) create a new request to get to the resource, the 
                user can see the new URL while request dispatch get the resource in same request and 
                URL does not changes.
                Also, another very important difference is that, sendRedirect() works on response object 
                while request dispatch work on request object. */
                String user=request.getParameter("user");
                // we have to explicitly pass the parameters to sendRedirect method
                response.sendRedirect("./admin_api?user="+user);
            }
            else if(request.getParameter("USER")!=null){
                out.println("<h1>Hello all from servlet</h1>");
                String user=request.getParameter("user");
                out.println("<h2> Welcome User "+user+"</h2>");
                /* ServletConfig interface methods application */
                ServletConfig sc=getServletConfig();
                out.println("<div><p><a href='"+sc.getInitParameter("GithubLink")+"'>Project Link</a></p>");
                out.println("<p>Servlet context <b>" + request.getServletContext() + "</b></p>");
                out.println("<p>Servlet name <b>" + sc.getServletName() + "</b></p>");
                out.println("<p>Initializing parameter name collection <b>" + sc.getInitParameterNames() + "</b></p></div>");
                out.println("</body>");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            out.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
