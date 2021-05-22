package com.jdbc_application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class database{
    String password="password";
    public void put_data(String Username, String Password, String date_of_birth) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root",password);
        Statement stmt1=con.createStatement();
        stmt1.executeUpdate( "CREATE DATABASE IF NOT EXISTS servlet_application ;");
        stmt1.executeUpdate("USE servlet_application;");
        stmt1.executeQuery("SELECT DATABASE();");
        String query1=(
                "CREATE TABLE IF NOT EXISTS store_user("+
                "Username varchar(30) NOT NULL PRIMARY KEY,"+
                "Password varchar(30) NOT NULL,"+
                "date_of_birth date NOT NULL,"+
                "date_register timestamp NOT NULL);"
                );
        stmt1.executeUpdate(query1);
        PreparedStatement stmt2=con.prepareStatement("INSERT INTO store_user VALUES(?,?,?,?)"); 
        stmt2.setString(1,Username);
        stmt2.setString(2, Password);
        stmt2.setDate(3, Date.valueOf(date_of_birth));
        java.sql.Timestamp timestamp = getCurrentJavaSqlTimestamp();
        System.out.println("timestamp=" + timestamp);
        stmt2.setTimestamp(4,timestamp);
        stmt2.executeUpdate();
        con.close();
    }

    private Timestamp getCurrentJavaSqlTimestamp() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Timestamp(date.getTime());
    }
    public void get_data(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application","root",password); 
        Statement stmt=con.createStatement();
        ResultSet rs1=stmt.executeQuery("SELECT * FROM store_user;");
        PrintWriter out=response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        while(rs1.next()){ 
            out.println("<p>"+rs1.getString(1)+' '
            +rs1.getString(2)+' '+rs1.getString(3)+' '+
            rs1.getString(4)+"</p>");
        }
    }
}
