package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateRPN = new EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = evaluateRPN.evalRPN(tokens);
        System.out.println("Result: " + result); // Output: 9
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str : tokens){
            if(isOperator(str)){
                int b = stack.pop();
                int a = stack.pop();
                int ans = evaluate(str, a, b);
                stack.push(ans);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }


    public boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int evaluate(String token, int operand1, int operand2) {
        return switch (token) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> 0;
        };
    }
}
