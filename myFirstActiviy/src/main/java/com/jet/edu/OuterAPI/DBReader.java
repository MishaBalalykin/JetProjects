package com.jet.edu.OuterAPI;

import com.jet.edu.InnerAPI.User;

import java.util.List;
import java.util.Map;

public interface DBReader {
    List<User> readFromBD();
}
