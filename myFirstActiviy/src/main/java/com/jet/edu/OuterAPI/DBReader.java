package com.jet.edu.OuterAPI;

import com.jet.edu.InnerAPI.User;

import java.util.List;

public interface DBReader {
    List<User> readFromBD();
}
