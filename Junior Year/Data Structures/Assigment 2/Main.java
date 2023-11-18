package hw2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("type your infix expression: ");
            String infix = scanner.nextLine();
            if (infix.isEmpty()) break;  // Exit if input is empty
            Converter converter = new Converter(infix);
            String postfix = converter.toPostFix();
            System.out.println("converted to postfix: " + postfix);
            double answer = PostfixCalculator.evaluate(postfix);
            System.out.println("answer is " + String.format("%.2f", answer));
            //System.out.println();  // This is for if you want the space but I wasn't sure if you wanted use to modify this file
		}
		scanner.close();
	}
}
