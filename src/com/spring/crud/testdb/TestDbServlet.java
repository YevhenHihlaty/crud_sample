package com.spring.crud.testdb;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String user = "springstudent";
        String password = "springstudent";

        String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to database - " + jdbcURL );
            Connection connection = DriverManager.getConnection(jdbcURL, user, password);

            out.println("Done!");
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }


    }
}
