import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * SLP_02_00 - Ein Beispielprogramm zur Demonstration der Dateierstellung und -verarbeitung in Java.
 * Dieses Programm erstellt mehrere Dateien und Ordner und schreibt Text in einige der Dateien.
 */
public class SLP_02_00 {
    public static void main(String[] args) {
        // 1. Erstellen von Dateien im Verzeichnis "docs"
        File datei1 = new File("docs/datei1.txt");
        try {
            datei1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File datei2 = new File("docs/datei2.txt");
        try {
            datei2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File datei3 = new File("docs/datei3.txt");
        try {
            datei3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File datei4 = new File("docs/datei4.txt");
        try {
            datei4.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 2. Erstellen von Ordnern und Dateien in diesen Ordnern
        File ordner1 = new File("docs/ordner1");
        ordner1.mkdir();

        File datei1_1 = new File("docs/ordner1/datei1_1.txt");
        try {
            datei1_1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File datei1_2 = new File("docs/ordner1/datei1_2.txt");
        try {
            datei1_2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File datei1_3 = new File("docs/ordner1/datei1_3.txt");
        try {
            datei1_3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        File ordner2 = new File("docs/ordner2");
        ordner2.mkdir();

        File datei2_1 = new File("docs/ordner2/datei2_1.txt");
        try {
            datei2_1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File datei2_2 = new File("docs/ordner2/datei2_2.txt");
        try {
            datei2_2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File datei2_3 = new File("docs/ordner2/datei2_3.txt");
        try {
            datei2_3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 3. Erstellen von Dateien in einem Ordner und Schreiben von Inhalten in diese Dateien

        File ordner3 = new File("docs/ordner3");
        ordner3.mkdir();

        if(ordner3.exists()) {
            File datei3_1 = new File("docs/ordner3/datei3_1.txt");
            try {
                datei3_1.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            File datei3_2 = new File("docs/ordner3/datei3_2.txt");
            try {
                datei3_2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (FileOutputStream fos1 = new FileOutputStream(datei3_1.toPath().toFile());
                 FileOutputStream fos2 = new FileOutputStream(datei3_2.toPath().toFile())) {
                fos1.write("Hallo Welt!".getBytes());
                fos2.write("Ciao Welt!".getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Ausgabe der Dateigröße
            System.out.println(datei3_1.length());
            System.out.println(datei3_2.length());

            // Ausgabe der Dateipfade
            System.out.println(datei3_1.getPath());
            System.out.println(datei3_2.getPath());

        }

    }
}
