package com.jet.web;

import com.jet.edu.InnerAPI.User;
import com.jet.edu.OuterAPI.DBReader;
import com.jet.edu.OuterAPI.OracleReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/viewUsers")
public class ViewUsers extends HttpServlet {
    private static List<User> users;
    private ApplicationContext context;
    private DBReader dbReader;

    public ViewUsers() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dbReader = (DBReader) context.getBean("oracleReader");
    }

    public static List<User> getUsers() {
        return users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("i'm hear");
        //DBReader dbReader = new OracleReader();
        users = dbReader.readFromBD();
        System.out.println(users);
        System.out.println("i'm hear");

        req.setAttribute("users", users);
        req.getRequestDispatcher("ViewUser.jsp").forward(req, resp);
    }
}
