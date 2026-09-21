package fileHandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryption {

    private static final int KEY = 3;

    public void encryptFile(String sourceFile, String encryptedFile) {

        try {
            FileReader fr = new FileReader(sourceFile);
            FileWriter fw = new FileWriter(encryptedFile);

            int ch;

            while ((ch = fr.read()) != -1) {
                fw.write(ch + KEY);
            }

            fr.close();
            fw.close();

            System.out.println("File encrypted successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}