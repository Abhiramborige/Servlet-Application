package com.jdbc_application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/success")
public class ServletFilter implements Filter{

    // https://www.geeksforgeeks.org/check-if-a-string-contains-uppercase-lowercase-special-characters-and-numeric-values/
    static boolean contain(String str){
        // ReGex to check if a string contains uppercase, lowercase special character & numeric value
        String regex = "^(?=.*[a-z])(?=." + "*[A-Z])(?=.*\\d)" + "(?=.*[-+_!@#$%^&*., ?]).+$";
        Pattern p = Pattern.compile(regex);
        // Find match between given string & regular expression
        Matcher m = p.matcher(str);
        if (m.matches()){
            return true;
        }
        else{
            return false;
        }
    }
    public void processFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request=(HttpServletRequest)request;
        response=(HttpServletResponse)response;
        PrintWriter out=response.getWriter();
        String conditional=(String) request.getParameter("button");

        if(conditional.contentEquals("Register")){
            String password=request.getParameter("Password");
            RequestDispatcher rd=request.getRequestDispatcher("data_insertion.jsp");
            if(password.length()<5){
                rd.include(request, response);
                out.println("<h3>Password length is less than 5 characters</h3>");
            }
            else if(contain(password)==false){
                rd.include(request, response);
                out.println("<h3>Password doesn't have either"+
                    "<ul><li>Upper case alphabet (or)</li>"+
                    "<li>Lower case alphabet (or)</li>"+
                    "<li>Number (or)</li>"+
                    "<li>Special character </li></ul></h3>");
            }
            else{
                chain.doFilter(request, response);
            }
        }
        else{
            chain.doFilter(request, response);
        }
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        processFilter(request, response, chain);
    }
}
