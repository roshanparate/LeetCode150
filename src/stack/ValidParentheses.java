package stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "()[]{}";
        boolean result = validParentheses.isValid(s);
        System.out.println("Is Valid Parentheses: " + result); // Output: true
    }


    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty()){
                char popCh = st.peek();
                if((ch == ')' && popCh == '(') || (ch == '}' && popCh == '{') || (ch == ']' && popCh == '[')){
                    st.pop();
                    continue;
                }
            }
            st.push(ch);
        }
        return st.isEmpty();
    }
}
