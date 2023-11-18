public class ExpressionTree {
    private Node root;

    // Build the expression tree from the postfix expression
    public void buildTree(String postfixExpression) {
        ArrayStack<Node> stack = new ArrayStack<>();
        String[] tokens = postfixExpression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                Node right = stack.pop();
                Node left = stack.pop();
                Node operator = new Node(token, left, right);
                stack.push(operator);
            } else {
                stack.push(new Node(token));
            }
        }
        root = stack.pop();
    }

    // Helper method to check if a string is an operator
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    // Preorder traversal for prefix notation
    public String prefix() {
        return prefix(root);
    }

    private String prefix(Node node) {
        if (node == null) return "";
        return node.element + " " + prefix(node.leftChild) + prefix(node.rightChild);
    }

    // Inorder traversal for infix notation
    public String infix() {
        return infix(root);
    }

    private String infix(Node node) {
        if (node == null) return "";
        if (isOperator(node.element.toString())) {
            return "(" + infix(node.leftChild) + " " + node.element + " " + infix(node.rightChild) + ")";
        }
        return node.element + " ";
    }

    // Postorder traversal for postfix notation
    public String postfix() {
        return postfix(root);
    }

    private String postfix(Node node) {
        if (node == null) return "";
        return postfix(node.leftChild) + postfix(node.rightChild) + node.element + " ";
    }
}
