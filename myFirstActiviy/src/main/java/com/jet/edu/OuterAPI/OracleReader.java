package com.jet.edu.OuterAPI;

import com.jet.edu.InnerAPI.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
