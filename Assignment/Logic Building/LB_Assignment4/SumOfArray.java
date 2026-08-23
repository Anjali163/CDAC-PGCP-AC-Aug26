import java.util.Scanner;

class SumOfArray{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

			System.out.println("Enter 5 integers:");

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        for (int x : arr) {
            sum = sum + x;
      }

        System.out.println("The sum of all numbers is: " + sum);
    }
}