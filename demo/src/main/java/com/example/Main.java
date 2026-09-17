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
        //fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "NameSoftware", "TIA", true, "Password");
        //fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "VersionSoftware", "V19", true, "NameSoftware");
        //fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "FilePathSoftware", "c:", true, "VersionSoftware");
        //fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "IconSoftware", "c:/icons", true, "FilePathSoftware");
        //fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "Note", "vide", true, "IconSoftware");
        fileJson.addKeyToAllLeaves(fJsonIn, fJsonOut, "TypeConnexion", "Rj45/profinet", true, "Sn/Modele");
        //Files.copy(fJsonOut.toPath(), new File("UsineNewVersion.json").toPath());
    }
}