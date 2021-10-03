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

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class database {
    String password = "abhiram*68*";

    public void put_data(String Username, String Password, String date_of_birth) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", this.password);
        Statement stmt1 = con.createStatement();
        stmt1.executeUpdate("CREATE DATABASE IF NOT EXISTS servlet_application ;");
        stmt1.executeUpdate("USE servlet_application;");
        stmt1.executeQuery("SELECT DATABASE();");
        /*
         * Set Username as promary key so that no two users with same username register.
         */
        String query1 = ("CREATE TABLE IF NOT EXISTS store_user(" + "Username VARCHAR(30) NOT NULL PRIMARY KEY,"
                + "Password VARCHAR(30) NOT NULL," + "date_of_birth date NOT NULL,"
                + "date_register timestamp NOT NULL);");
        stmt1.executeUpdate(query1);
        PreparedStatement stmt2;
        /* NULLIF is to return NULL if both parameters are same */
        stmt2 = con.prepareStatement("INSERT INTO store_user VALUES" + "(NULLIF(?,''),NULLIF(?,''),NULLIF(?,''),?);");
        stmt2.setString(1, Username);
        stmt2.setString(2, Password);
        stmt2.setDate(3, Date.valueOf(date_of_birth));
        java.sql.Timestamp timestamp = getCurrentJavaSqlTimestamp();
        stmt2.setTimestamp(4, timestamp);
        stmt2.executeUpdate();
        con.close();
    }

    private Timestamp getCurrentJavaSqlTimestamp() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Timestamp(date.getTime());
    }

    public void get_data(HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application", "root",
                this.password);
        Statement stmt = con.createStatement();
        ResultSet rs1 = stmt.executeQuery("SELECT * FROM store_user ORDER BY date_register;");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<p>");
        while (rs1.next()) {
            out.println(rs1.getString(1) + ' ' + rs1.getString(2) + ' ' + rs1.getString(3) + ' ' + rs1.getString(4)
                    + "<br>");
        }
        out.println("</p>");
    }

    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response)
            throws ClassNotFoundException, SQLException, IOException, ServletException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application", "root",
                this.password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM store_user WHERE Username=" + "'" + username + "';");
        if (!rs.next()) {
            throw new SQLException("No Username found");
        } else {
            rs = stmt.executeQuery("SELECT * FROM store_user WHERE Username=" + "'" + username + "' AND password=" + "'"
                    + password + "';");
            if (!(rs.next())) {
                throw new SQLException("Invalid Password");
            } else {
                // if username and password is found in the database,
                // put details in the session till user logs out.
                String method = response.getHeader("method");
                System.out.println("Login: " + method);
                if (method == "session") {
                    HttpSession session = request.getSession();
                    // storing the username in the session is enough as it is primary key
                    session.setAttribute("Username", username);
                } else if (method == "cookie") {
                    Cookie loginCookie = new Cookie("Username", username);
                    response.addCookie(loginCookie);
                }
                // redirect to User home page.
                response.sendRedirect("home_user.jsp");
            }
        }
    }

    public void delete_row(String username) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application", "root",
                this.password);
        Statement stmt = con.createStatement();

        // https://stackoverflow.com/questions/2571915/return-number-of-rows-affected-by-sql-update-statement-in-java
        int update_count = stmt.executeUpdate("DELETE FROM store_user WHERE Username='" + username + "';");
        if (update_count > 0) {
            throw new SQLException("User data deleted!");
        } else {
            throw new SQLException("No User with specified Username found!");
        }
    }

    public void update_row(String username, String oldPassword, String newPassword)
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_application", "root",
                this.password);
        Statement stmt = con.createStatement();

        int update_count = stmt.executeUpdate("UPDATE store_user SET password='" + newPassword + "' WHERE username='"
                + username + "' AND password='" + oldPassword + "';");
        if (update_count > 0) {
            throw new SQLException("User password updated!");
        } else {
            throw new SQLException("Username/password not found!");
        }
    }
}
