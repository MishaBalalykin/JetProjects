package com.jet.edu;

import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ConsolWriter {
    Initialaizer initialaizer = new Initialaizer();
    FileWriter fw;

    {
        try {
            fw = new FileWriter(new File("aValue.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMessageAZero(ActivityExecution execution) {
        System.out.println("zero " + initialaizer.a);
        try {
            fw.write("zero " + initialaizer.a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMessageA(ActivityExecution execution) {
        System.out.println("not zero " + initialaizer.a);
        try {
            fw.write("not zero " + initialaizer.a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
