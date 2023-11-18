import java.util.Random;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char ch = '\0';

        while (ch != 'a' && ch != 'A') {
            System.out.println("Enter 'a' or 'A': ");
            ch = scanner.nextLine().charAt(0);
            if (ch == 'a') {
                System.out.println((char) (random.nextInt(26) + 'a'));
            } else if (ch == 'A') {
                System.out.println((char) (random.nextInt(26) + 'A'));
            } else {
                System.out.println("Invalid entry, please try again.");
            }
        }

        scanner.close();
    }
}
