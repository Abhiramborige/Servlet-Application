
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<head>
    <link rel='stylesheet' type='text/css' href='./styling/style.css'>
</head>

<h2>The databse have these users registered through this form.</h2>


<% 
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application","root","<password>");
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("SELECT * FROM store_user;"); 
%>
<table>
    <tr>
        <td>Seriel number</td>
        <td>Username</td>
        <td>Password</td>
        <td>Date of birth</td>
        <td>Registered date</td>
    </tr>
    <% int i=0;
        while(rs.next()){ %>
        <tr>
            <td><%= i+1 %></td>
            <td><%= rs.getString(1) %></td>
            <td><%= rs.getString(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
        </tr>
        <% i++;
    } 
    i=0;
    %>
</table>

