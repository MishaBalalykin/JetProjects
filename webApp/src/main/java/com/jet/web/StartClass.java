package com.jet.web;

import com.jet.edu.OuterAPI.OuterAPI;
import com.jet.edu.OuterAPI.StandartAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/start")
public class StartClass extends HttpServlet {
    String name;
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    OuterAPI start = (OuterAPI) context.getBean("api");
    //OuterAPI start = new StandartAPI();


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
            System.out.println("aaaa");
            start.start();
            System.out.println("i'm hear");
            //Runtime.getRuntime().exec("java -jar myFirstActiviy.jar");
            System.out.println("i'm steel hear");
        } else System.out.println("error");

       /* mvn install:install-file -Dfile=<C:\Users\mr.balalykin\Downloads\Repo\JetProjects\myFirstActiviy\out\artifacts\myFirstActiviy_jar> -DgroupId=<com.jet.edu> \ -DartifactId=<myFirstActiviy> -Dversion=<1.0-SNAPSHOT> -Dpackaging=jar
          mvn install:install-file -Dfile=C:\Users\mr.balalykin\Downloads\Repo\JetProjects\myFirstActiviy\target\myFirstActiviy-1.0-SNAPSHOT.jar -DpomFile=C:\Users\mr.balalykin\Downloads\Repo\JetProjects\myFirstActiviy\pom.xml*/
    }
}
