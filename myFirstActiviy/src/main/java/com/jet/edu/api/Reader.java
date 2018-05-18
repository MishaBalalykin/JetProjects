package com.jet.edu.api;

import com.jet.edu.users.User;
import org.springframework.beans.factory.BeanCreationException;

import java.util.List;

public interface Reader {
    List<User> readFromBD();
}
/*mvn install:install-file -Dfile=C:\Users\mr.balalykin\Downloads\Repo\JetProjects\myFirstActiviy\target\myFirstActiviy-1.0-SNAPSHOT.jar -DpomFile=C:\Users\mr.balalykin\Downloads\Repo\JetProjects\myFirstActiviy\pom.xml*/
