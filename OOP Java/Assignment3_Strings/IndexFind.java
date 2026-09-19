package in.cdac;

public class IndexFind {

    public static void main(String[] args) {

        String str = "The quick brown fox jumps over the lazy dog";

        // a to j
        for (char ch = 'a'; ch <= 'j'; ch++) {
            System.out.print(ch + " ");
        }

        System.out.println();
        System.out.println("=========================");

        for (char ch = 'a'; ch <= 'j'; ch++) {
            int index = str.indexOf(ch);
            System.out.print(index + " ");
        }

        System.out.println();
        System.out.println();

        // k to t
        for (char ch = 'k'; ch <= 't'; ch++) {
            System.out.print(ch + " ");
        }

        System.out.println();
        System.out.println("=========================");

        for (char ch = 'k'; ch <= 't'; ch++) {
            int index = str.indexOf(ch);
            System.out.print(index + " ");
        }

        System.out.println();
        System.out.println();

        // u to z
        for (char ch = 'u'; ch <= 'z'; ch++) {
            System.out.print(ch + " ");
        }

        System.out.println();
        System.out.println("================");

        for (char ch = 'u'; ch <= 'z'; ch++) {
            int index = str.indexOf(ch);
            System.out.print(index + " ");
        }
    }
}