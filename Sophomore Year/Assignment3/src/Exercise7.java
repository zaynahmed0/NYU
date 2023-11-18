import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double accountBalance = 0.0;

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. View your account balance");
            System.out.println("2. Deposit cash");
            System.out.println("3. Withdraw cash");
            System.out.println("4. Exit");
            System.out.println("Enter your selection: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect selection, please try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Your account balance is: " + accountBalance);
                    break;
                case 2:
                    System.out.println("How much do you want to deposit?");
                    double depositAmount = 0.0;
                    while (true) {
                        try {
                            depositAmount = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid entry, please try again.");
                        }
                    }
                    accountBalance += depositAmount;
                    System.out.println("Deposit successful. Your account balance is now: " + accountBalance);
                    break;
                case 3:
                    System.out.println("How much do you want to withdraw?");
                    double withdrawAmount = 0.0;
                    while (true) {
                        try {
                            withdrawAmount = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid entry, please try again.");
                        }
                    }
                    if (withdrawAmount > accountBalance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        accountBalance -= withdrawAmount;
                        System.out.println("Withdrawal successful. Your account balance is now: " + accountBalance);
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Incorrect selection, please try again.");
                    break;
            }
        }
    }
}
