import java.util.Scanner;
import java.util.Arrays;

class CheckEleExists{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer[] arr = new Integer[5];

        System.out.println("Enter 5 integers:");

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

				System.out.print("Enter the number to search: ");
					int number = sc.nextInt();
       
        if (Arrays.asList(arr).contains(number)) {
            System.out.println("Found");
        }
        else {
            System.out.println("Not Found");
        }
    }
}