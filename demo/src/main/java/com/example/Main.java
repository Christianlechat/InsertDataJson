package com.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        File fJsonIn  = new File("usine.json");
        File fJsonOut = new File("result.json");
        fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "Soft", "v1", false, "Password");
    }
}