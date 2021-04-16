package com.abhiram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class admin extends HttpServlet {
    
    private static final long serialVersionUID = 2595124483992980425L;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /* Usage of some methods in HttpServletResponse and ServletResponse interfaces */
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        try{
            String cssTag="<link rel='stylesheet' type='text/css' href='./styling/style.css'>";
            out.println("<head><title>Servlet Home Page</title>"+cssTag+"</head>");
            out.println("<body>");
            out.println("<h1>Hello all from servlet</h1>");
            /* Usage of some methods in HttpServletRequest and ServletRequest interfaces */
            out.println("<div><p>Context Path at <b>" + request.getContextPath() + "</b></p>");
            out.println("<p>Servlet Path at <b>" + request.getServletPath() + "</b></p>");
            out.println("<p>Status code of application <b>" + response.getStatus() + "</b></p>");
            out.println("<p>Server name <b>" + request.getServerName() + "</b></p>");
            out.println("<p>Servlet context <b>" + request.getServletContext() + "</b></p>");
            out.println("<p>Response character encoding <b>" + response.getCharacterEncoding() + "</b></p>");
            out.println("<p>Is request made using secure channel <b>" + request.isSecure() + "</b></p>");
            out.println("<p>Request Port number <b>" + request.getServerPort() + "</b></p>");
            out.println("<p>Parameters names collection <b>" + request.getParameterNames() + "</b></p>");
            out.println("<p>Attribute names collection <b>" + request.getAttributeNames() + "</b></p>");
            out.println("<p>Request URI <b>" + request.getRequestURI() + "</b></p>");
            out.println("<p>Protocol <b>" + request.getProtocol() + "</b></p>");
            out.println("<p>PathInfo <b>" + request.getPathInfo() + "</b></p>");
            out.println("<p>Remote Address <b>" + request.getRemoteAddr() + "</b></p>");
            out.println("<p>Authentication type <b>" + request.getAuthType()+ "</b></p></div>");
            String user=request.getParameter("user");
            out.println("<h2> Welcome Admin "+user+"</h2>");
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            out.close();
        }
        
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
