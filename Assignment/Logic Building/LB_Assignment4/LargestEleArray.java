import java.util.Scanner;

class LargestEleArray{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.print("Enter 5 integers:");

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = arr[0];

        for (int i = 1; i < 5; i++) {

            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("The largest element is: " + largest);
    }
}