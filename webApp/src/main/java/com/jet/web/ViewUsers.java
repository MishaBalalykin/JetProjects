package com.jet.web;

import com.jet.edu.InnerAPI.User;
import com.jet.edu.OuterAPI.DBReader;
import com.jet.edu.OuterAPI.OracleReader;
import com.jet.edu.OuterAPI.OuterAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/viewUsers")
public class ViewUsers extends HttpServlet {
    public List<User> users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("i'm hear");
        DBReader dbReader = new OracleReader();
        users = dbReader.readFromBD();
        System.out.println(users);
        System.out.println("i'm hear");

//        req.setAttribute("users", users);
        req.setAttribute("users", users);
        req.getRequestDispatcher("ViewUser.jsp").forward(req, resp);
    }
}
