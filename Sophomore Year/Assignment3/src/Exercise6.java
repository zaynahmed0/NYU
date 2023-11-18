import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (password.length() < 8) {
            System.out.println("Weak password");
        } else if (password.length() > 12) {
            System.out.println("Awesome password");
        } else if (password.matches("\\d+")) {
            System.out.println("Medium password (only numbers)");
        } else if (password.matches("[a-zA-Z]+")) {
            System.out.println("Medium password (only letters)");
        } else if (password.matches("[a-z\\d]+")) {
            System.out.println("OK password (all lower case)");
        } else if (password.matches("[A-Z\\d]+")) {
            System.out.println("OK password (all upper case)");
        } else if (password.matches("[a-zA-Z\\d]+")) {
            System.out.println("Strong password");
        } else {
            System.out.println("Invalid password");
        }
    }
}
