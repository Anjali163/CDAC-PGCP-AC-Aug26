import java.util.Scanner;

class GoodMorning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the time");
        int time = sc.nextInt();

        if (time >= 5 && time <= 12) {
            System.out.println("Good Morning");
        }else {
            System.out.println("Not valid time for morning");
        }
    }
}