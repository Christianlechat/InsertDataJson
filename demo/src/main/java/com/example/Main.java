package com.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        File fJson  = new File("usine.json");
        fileJson.addKeyToAllLeaves(fJson, "Soft", "v1", true, "User");
    }
}