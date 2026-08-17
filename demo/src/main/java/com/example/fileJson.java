package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class fileJson {
    static String key;
    static String value;
    static int spacesCount;

    public static void addKeyToAllLeaves(File fileJson, String newKey, String newValue, boolean after, String existingKey) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileJson))) {

            String line;
            String lineTrim;
            String newdata;
            

            while ((line = br.readLine()) != null) {
                lineTrim = line.trim();

                System.out.println(line);
                
                if (lineTrim.isEmpty() || lineTrim.startsWith(";") || lineTrim.startsWith("#")) continue;
                if (lineTrim.contains(":")){
                    int idx = lineTrim.indexOf(':');
                    key = lineTrim.substring(1, idx-1).trim();
                    value = lineTrim.substring(idx + 1).trim();
                    if (key.equals(existingKey)) {
                        // Ajouter la nouvelle clé/valeur après la clé existante
                        spacesCount = compterEspacesDebut(line);
                        if (after) {
                            System.out.printf("Adding new key: %s, Value: %s after existing key:  spaces: %d%n", newKey, newValue, spacesCount);
                            newdata = "\"" + newKey + "\": \"" + newValue;
                            System.out.printf(newdata.indent(spacesCount));
                        } else {
                            System.out.printf("Adding new key: %s, Value: %s before existing key: %s%n", newKey, newValue, existingKey);
                            newdata = "\"" + newKey + "\": \"" + newValue;
                            System.out.printf(newdata.indent(spacesCount));                        }
                    }
                    System.out.println(line);
                    System.out.printf("Key: %s, Value: %s %n", key, value);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                null,
                "Erreur lors de la lecture des clé/valeur.",
                "Erreur.",
                JOptionPane.WARNING_MESSAGE
            );
            throw new RuntimeException("Erreur lors de la récupération du chemin du JAR", e);
            
        }
    }
    static int compterEspacesDebut(String texte) {
        if (texte == null || texte.isEmpty()) {
            return 0;
        }

        int compteur = 0;
        // Parcourir la chaîne tant que le caractère est un espace
        for (int i = 0; i < texte.length(); i++) {
            if (Character.isSpaceChar(texte.charAt(i))) {
                compteur++;
            } else {
                // Dès qu'on rencontre un caractère non-espace, on arrête
                break;
            }
        }
        return compteur;
    } 

}