import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileReaderUtil {
    public static int citesteNumarDinFisier(String numeFisier) {
        try {
            File fisier = new File(numeFisier);
            Scanner scanner = new Scanner(fisier);

            int x = scanner.nextInt();
            scanner.close();
            return x;
        } catch (FileNotFoundException e) {
            System.out.println("Eroare: Fisierul nu a fost gasit! Folosim valoarea implicita x = 1.");
        } catch (Exception e) {
            System.out.println("Eroare: Continut invalid în fisier! Folosim valoarea implicita x = 1.");
        }
        return 1; 
    }
}

public class Main {
    public static void main(String[] args) {
        int x = FileReaderUtil.citesteNumarDinFisier("numar.txt");
        int rezultat = 2 * x;
        System.out.println("Rezultatul este: " + rezultat);
    }
}
