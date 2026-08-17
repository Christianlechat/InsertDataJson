package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class JsonRecursiveUpdater {

    public static void addKeyToAllLeaves(String filePath, String key, String value) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File(filePath));

        // Lancer la récursion
        processNode(rootNode, key, value);

        // Sauvegarder le fichier modifié
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), rootNode);
    }

    private static void processNode(JsonNode node, String key, String value) {
        if (node.isObject()) {
            // 1. Ajouter la clé à l'objet courant
            ((ObjectNode) node).put(key, value);

            // 2. Parcourir les enfants pour continuer la récursion
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                JsonNode child = fields.next().getValue();
                processNode(child, key, value);
            }
        } else if (node.isArray()) {
            // Si c'est un tableau, on traite chaque élément
            for (JsonNode element : node) {
                processNode(element, key, value);
            }
        }
        // Les feuilles primitives (String, Int, Boolean) ne sont pas modifiées directement,
        // car on ne peut pas ajouter une clé à une valeur primitive. 
        // La clé a déjà été ajoutée à l'objet parent lors de l'étape précédente.
    }
}   