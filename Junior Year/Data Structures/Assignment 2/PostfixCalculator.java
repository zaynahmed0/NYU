package hw2;

public class PostfixCalculator {
    // Method evaluates postfix expression passed as a string
    public static double evaluate(String postfixExpression) {
        // Create stack to hold operands
        Stack<Double> operandStack = new ArrayStack<>();

        // Split input expression into tokens
        String[] tokens = postfixExpression.split(" ");

        // Loop through each token
        for (String token : tokens) {
            // Check if the token is a digit
            if (Character.isDigit(token.charAt(0))) {
                // Push operand to stack
                operandStack.push(Double.valueOf(token));
            } else {
                // Pop top two operands from stack for operation
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();

                // Perform the operation
                switch (token) {
                    case "+":
                        operandStack.push(operand1 + operand2);
                        break;
                    case "-":
                        operandStack.push(operand1 - operand2);
                        break;
                    case "*":
                        operandStack.push(operand1 * operand2);
                        break;
                    case "/":
                        operandStack.push(operand1 / operand2);
                        break;
                    case "^":
                        operandStack.push(Math.pow(operand1, operand2));
                        break;
                }
            }
        }

        // Return final result from stack
        return operandStack.pop();
    }
}
