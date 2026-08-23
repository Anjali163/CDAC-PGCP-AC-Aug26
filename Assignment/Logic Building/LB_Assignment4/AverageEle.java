import java.util.Scanner;

class AverageEle{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 integers:");
        
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            sum = sum + arr[i];
        }
        
        double average = (double) sum / 5;

        System.out.println("The average of the numbers is: " + average);
    }
}