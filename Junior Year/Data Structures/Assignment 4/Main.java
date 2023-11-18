import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Read infix expression from console
            System.out.print("Type your expression: ");
            String infixExpression = scanner.nextLine();

            // Create a Converter object
            Converter converter = new Converter(infixExpression);

            // Convert infix to postfix
            String postfixExpression = converter.toPostFix();

            // Build expression tree
            ExpressionTree tree = new ExpressionTree();
            tree.buildTree(postfixExpression);

            // Print traversals
            System.out.println("Prefix: " + tree.prefix());
            System.out.println("Infix: " + tree.infix());
            System.out.println("Postfix: " + tree.postfix());
        }
    }
}
