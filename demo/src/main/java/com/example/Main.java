package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        File fJsonIn  = new File("usine.json");
        File fJsonOut = new File("result.json");
        if (fJsonOut.exists()) {
            fJsonOut.delete();
        }
        fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "NameSoftware", "TIA", true, "Password");
        Files.copy(fJsonOut.toPath(), new File("UsineNewVersion.json").toPath());
    }
}