
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table data here</title>
    <link rel='stylesheet' type='text/css' href='./styling/style.css'>
</head>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<h2>The databse have these users registered through this form.</h2>

<%! String password="password"; %>

<% 
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application","root",password);
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("SELECT * FROM store_user;"); 
%>
<div>
    <table>
        <thead>
            <tr>
                <td>Seriel number</td>
                <td>Username</td>
                <td>Password</td>
                <td>Date of birth</td>
                <td>Registered date</td>
            </tr>
        </thead>
        <tbody>
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
        </tbody>
    </table>
</div>
