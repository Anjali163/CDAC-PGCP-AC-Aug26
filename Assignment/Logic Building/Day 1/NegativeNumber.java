import java.util.Scanner;

class NegativeNumber {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int num = sc.nextInt();
        
        if (num < 0) {
            System.out.println("Negative Number");
        } else {
            System.out.println("Not a Negative Number");
        }
    }
}