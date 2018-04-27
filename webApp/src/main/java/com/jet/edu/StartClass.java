package com.jet.edu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/start")
public class StartClass extends HttpServlet {
    String name;
    //String[] args = new String[10];


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action=\"start\">\n" +
                "        Enter \"start\" <input type=\"text\" name=\"startBPM\">\n" +
                "        <input type=\"submit\" value=\"Start BPM\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</body>\n" +
                "</html>");
        name = req.getParameter("startBPM");
        System.out.println("name " + name);
        if (name.equalsIgnoreCase("start")) {
            /*Main main = new Main();
            main.start();*/
            System.out.println("i'm hear");
            Runtime.getRuntime().exec("java -jar myFirstActiviy.jar");
            System.out.println("i'm steel hear");
        } else System.out.println("error");

    }
}
