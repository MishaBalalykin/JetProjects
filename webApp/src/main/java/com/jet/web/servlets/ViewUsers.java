package com.jet.web.servlets;

import com.jet.edu.service.DatabaseReaderService;
import com.jet.edu.users.User;
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
    private ClassPathXmlApplicationContext context;
    private DatabaseReaderService dbReader;

    public ViewUsers() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dbReader = context.getBean("databaseReaderService", DatabaseReaderService.class);
    }

    public static List<User> getUsers() {
        return users;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        users = dbReader.readFromOracleBD();
        req.setAttribute("users", users);
        req.getRequestDispatcher("ViewUser.jsp").forward(req, resp);
    }
}
