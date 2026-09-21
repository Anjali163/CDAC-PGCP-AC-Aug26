package fileHandling;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decryption {

    private static final int KEY = 3;

    public void decryptFile(String encryptedFile, String decryptedFile) {

        try {
            FileReader fr = new FileReader(encryptedFile);
            FileWriter fw = new FileWriter(decryptedFile);

            int ch;

            while ((ch = fr.read()) != -1) {
                fw.write(ch - KEY);
            }

            fr.close();
            fw.close();

            System.out.println("File decrypted successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

