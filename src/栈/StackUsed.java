package 栈;

import java.util.Stack;

/**
 * des: leetcode中的一个例子   括号匹配  (())[]能匹配上就true, {(]}不能匹配上返回false
 * created by miapoeng on 2019/8/12 14:37
 */
public class StackUsed {
    public static void main(String[] args) {
        System.out.println(mathKuoHao("()(())[]()[[[]]]"));
    }
    private static boolean mathKuoHao (String kuohao) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < kuohao.length(); i++) {
            char ch = kuohao.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.empty()) {
                    return false;
                }
                char lastChar = stack.peek();
                if (lastChar == '(' && ch == ')') {
                    stack.pop();
                }
                if (lastChar == '[' && ch == ']') {
                    stack.pop();
                }
                if (lastChar == '{' && ch == '}') {
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
