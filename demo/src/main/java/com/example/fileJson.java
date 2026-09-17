package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class fileJson {
    //static BufferedReader br;
    static String key;
    static String value;
    static int spacesCount;

    public static void addKeyToAllLeaves(File fileJsonIn, File fileJsonOut, String newKey, String newValue, boolean after, String existingKey) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileJsonIn));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileJsonOut, false))) {

            String line;
            String lineTrim;
            String newdata;
            String insertData;
            

            while ((line = br.readLine()) != null) {
                lineTrim = line.trim();

                //System.out.println(line);
                
                if (lineTrim.isEmpty() || lineTrim.startsWith(";") || lineTrim.startsWith("#")) continue;
                if ((lineTrim.contains(":" ) || lineTrim.contains("{") || lineTrim.contains("}"))) {
                    int idx = lineTrim.indexOf(':');
                    key = lineTrim.substring(1, idx-1).trim();
                    value = lineTrim.substring(idx + 1).trim();
                    if (key.equals(existingKey)) {
                        // Ajouter la nouvelle clé/valeur après la clé existante
                        spacesCount = compterEspacesDebut(line);
                        newdata = "\"" + newKey + "\": \"" + newValue + "\"";
                        insertData = newdata.indent(spacesCount);
                        if (after) {
                            //System.out.printf("Adding new key: %s, Value: %s after existing key:  spaces: %d%n", newKey, newValue, spacesCount);
                            if (!line.isEmpty() && line.charAt(line.length() - 1) == ',') {
                                bw.write(line);
                                bw.newLine();
                                bw.write(insertData);
                            } else {
                                bw.write(line + ",");
                                bw.newLine();
                                bw.write(insertData);
                            }
                            //bw.newLine();
                            //System.out.printf(newdata.indent(spacesCount));
                        } else {
                            bw.write(insertData + ",");
                            //bw.newLine();    
                            bw.write(line);
                            bw.newLine();                }
                    }
                    else {
                        // Écrire la ligne telle quelle dans le fichier de sortie
                        bw.write(line);
                        bw.newLine();
                    }
                    System.out.println(line);
                    System.out.printf("Key: %s, Value: %s %n", key, value);
                    
                }
            }
            br.close();
            bw.close();
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