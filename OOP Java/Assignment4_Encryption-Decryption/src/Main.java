package fileHandling;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();

        int choice = 0;

        try {

            do {

                System.out.println("\n===== FILE ENCRYPTION MENU =====");
                System.out.println("1. Encrypt File");
                System.out.println("2. Decrypt File");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                choice = Integer.parseInt(br.readLine());

                switch (choice) {

                case 1:

                    System.out.print("Enter source file name: ");
                    String sourceFile = br.readLine();

                    System.out.print("Enter encrypted file name: ");
                    String encryptedFile = br.readLine();

                    encryption.encryptFile(sourceFile, encryptedFile);

                    break;

                case 2:

                    System.out.print("Enter encrypted file name: ");
                    String encFile = br.readLine();

                    System.out.print("Enter decrypted file name: ");
                    String decFile = br.readLine();

                    decryption.decryptFile(encFile, decFile);

                    break;

                case 3:

                    System.out.println("Program ended.");
                    break;

                default:

                    System.out.println("Invalid choice.");
                }

            } while (choice != 3);

        } catch (IOException e) {

            System.out.println("Input error: " + e.getMessage());
        }
    }
}