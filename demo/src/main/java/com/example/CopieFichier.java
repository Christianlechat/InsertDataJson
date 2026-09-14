import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopieFichier {
    public static void main(String[] args) {
        try {
            Path source = Paths.get("chemin/vers/source.txt");
            Path destination = Paths.get("chemin/vers/destination.txt");
            
            // Copie le fichier, écrase si la destination existe déjà
            Files.copy(source, destination, REPLACE_EXISTING);
            System.out.println("Fichier copié avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   