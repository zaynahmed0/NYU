package hw2;

public class Converter {
    // Instance variables to store the infix expression and operator stack
    private String infixExpression;
    private ArrayStack<String> operatorStack;

    // Initializes the infix expression, creates new operator stack
    public Converter(String infixExpression) {
        this.infixExpression = infixExpression;
        // Assuming max stack size of 50
        this.operatorStack = new ArrayStack<>(50);
    }

    // Determine precedence of operator
    public int precedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }

    // Method to convert infix expression to postfix expression
    public String toPostFix() {
        // Convert infix expression to character array
        char[] tokens = infixExpression.toCharArray();
        // Store postfix expression
        StringBuilder postfix = new StringBuilder();

        // Iterate through each character in  infix expression
        for (char token : tokens) {
            String tokenStr = String.valueOf(token);
            // If token is digit append it to postfix expression
            if (Character.isDigit(token)) {
                postfix.append(token).append(" ");
            }
            // If token is open parenthesis push it onto stack
            else if (token == '(') {
                operatorStack.push(tokenStr);
            }
            // If token is a close parenthesis pop operators from stack and append postfix
            else if (token == ')') {
                while (!operatorStack.isEmpty() && !operatorStack.top().equals("(")) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop(); // Remove open parenthesis from stack
            }
            // Handle operators
            else {
                while (!operatorStack.isEmpty() && precedence(operatorStack.top()) >= precedence(tokenStr)) {
                    postfix.append(operatorStack.pop()).append(" ");
                }
                // Push current operator onto stack
                operatorStack.push(tokenStr);
            }
        }

        // Append remaining operators from the stack to postfix
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop()).append(" ");
        }
        // Return postfix expression
        return postfix.toString().trim();
    }
}
