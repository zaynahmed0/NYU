import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a month: ");
        String month = scanner.nextLine().toLowerCase();

        if (month.equals("december") || month.equals("january") || month.equals("february")) {
            System.out.println("Season is: Winter");
        } else if (month.equals("march") || month.equals("april") || month.equals("may")) {
            System.out.println("Season is: Spring");
        } else if (month.equals("june") || month.equals("july") || month.equals("august")) {
            System.out.println("Season is: Summer");
        } else if (month.equals("september") || month.equals("october") || month.equals("november")) {
            System.out.println("Season is: Fall");
        } else {
            System.out.println("Invalid month entered.");
        }
    }
}
