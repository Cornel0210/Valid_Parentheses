import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("(("));
        System.out.println(isValid("(([{}]))"));
        System.out.println(isValid("(){}}{"));
    }

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     */
    public static boolean isValid(String s) {
        if (s.length() <= 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char ch;
        char chStack;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.add(ch);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                chStack = stack.pop();
                if (chStack == '(' && ch != ')'){
                    return false;
                }
                if (chStack == '[' && ch != ']'){
                    return false;
                }
                if (chStack == '{' && ch != '}'){
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
