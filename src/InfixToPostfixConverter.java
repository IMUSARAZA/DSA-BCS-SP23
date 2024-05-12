import java.util.Stack;

public class InfixToPostfixConverter {

    public static String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == ' ') {
                continue; // ignore whitespace
            } else if (Character.isDigit(ch)) {
                postfix.append(ch); // output operand
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && precedence(ch) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop()); // output higher or equal precedence operators
                }
                operatorStack.push(ch);
            } else if (ch == '(') {
                operatorStack.push(ch); // push opening parenthesis onto stack
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop()); // output operators until opening parenthesis is found
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop(); // discard opening parenthesis
                }
            } else {
                throw new IllegalArgumentException("Invalid character in infix expression: " + ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                throw new IllegalArgumentException("Mismatched parentheses in infix expression");
            }
            postfix.append(operatorStack.pop()); // output remaining operators
        }

        return postfix.toString();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
