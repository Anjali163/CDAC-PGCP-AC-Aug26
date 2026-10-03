package dsa;
import java.util.Scanner;

public class MoveZeros {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter the array elements: ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		move(arr);
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	public static int[] move(int arr[]) {
		int nonZero = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[nonZero];
				arr[nonZero] = arr[i];
				arr[i] = temp;
				nonZero++;
			}
		}

		return arr;
	}

}