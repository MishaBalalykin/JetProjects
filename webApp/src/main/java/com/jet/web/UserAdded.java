package com.jet.web;

import com.jet.edu.OuterAPI.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/userAdded")
public class UserAdded extends HttpServlet {
    private ApplicationContext context;
    private DBWriter dbWriter;

    public UserAdded() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        dbWriter = (DBWriter) context.getBean("oracleWriter");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("UserAdded.jsp").forward(req, resp);
        Map<String, Object> users = new HashMap<>();
        users.put("surname", req.getParameter("surname"));
        users.put("name", req.getParameter("name"));
        users.put("age", req.getParameter("age"));
        dbWriter.start(users);
    }
}
