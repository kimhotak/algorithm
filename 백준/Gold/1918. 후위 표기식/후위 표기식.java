import java.io.*;
import java.util.*;

public class Main {
    public static int getPriority(char op) {
        if (op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char[] str = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c: str) {
            if (Character.isLetter(c)) sb.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')') {
                while (stack.peek() != '(') sb.append(stack.pop());
                stack.pop();
            }
            else {
                while (!stack.isEmpty() &&
                        getPriority(stack.peek()) >= getPriority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.print(sb);
    }
}