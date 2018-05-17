package com.jet.edu.OuterAPI;

import com.jet.edu.InnerAPI.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OracleReader implements DBReader {
    @Override
    public List<User> readFromBD() {
        List<User> users = new ArrayList<>();
        com.jet.edu.InnerAPI.DBReader dbReader = new com.jet.edu.InnerAPI.DBReader();
        try {
            users = dbReader.readFromOracleBD();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    /*public static void main(String[] args) {
        OracleReader oracleReader = new OracleReader();
        System.out.println(readFromBD());
    }*/
}
