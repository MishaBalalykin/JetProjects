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
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    /*DBWriter dbWriter = (DBWriter) context.getBean("oracleWriter");*/
    OracleWriter dbWriter = new OracleWriter();

    //    OuterAPI outerAPI = new StandartAPI();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("UserAdded.jsp").forward(req, resp);
        Map<String, Object> users = new HashMap<>();
        users.put("surname", req.getParameter("surname"));
        users.put("name", req.getParameter("name"));
        users.put("age", req.getParameter("age"));
        System.out.println(1);
        OracleWriter dbWriter = new OracleWriter();
        dbWriter.start(users);
//        Test test = new Test();
//        System.out.println(test.test());
        System.out.println(2);
    }
}
