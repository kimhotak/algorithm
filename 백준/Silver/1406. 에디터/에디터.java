import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        
        for (char c: br.readLine().toCharArray()) {
            left.addLast(c);
        }
        
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            char op = st.nextToken().charAt(0);
            
            if (op == 'L') {
                if (left.isEmpty()) continue;
                right.addFirst(left.pollLast());
            }
            else if (op == 'D') {
                if (right.isEmpty()) continue;
                left.addLast(right.pollFirst());
            }
            else if (op == 'B') {
                if (left.isEmpty()) continue;
                left.pollLast();
            }
            else if (op == 'P') {
                left.addLast(st.nextToken().charAt(0));
            }
        }
        
        while (!left.isEmpty()) {
            sb.append(left.pollFirst());
        }
        while (!right.isEmpty()) {
            sb.append(right.pollFirst());
        }

        System.out.print(sb);
    }
}