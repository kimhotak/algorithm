import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Deque<Integer> dq = new ArrayDeque<>();
        int res = 0;
        boolean wrong = false;

        int i = 0;
        while (i < str.length()) {
            char s = str.charAt(i);
            if (s == '(' || s == '[') {
                dq.addLast(str.charAt(i) == '(' ? 2 : 3);
                i++;
            }
            else if ((s == ')' && !dq.isEmpty() && dq.peekLast() == 2) ||
                    (s == ']' && !dq.isEmpty() && dq.peekLast() == 3)) {
                int tmp = 1;
                for (int v : dq) tmp *= v;
                res += tmp;
                while (i < str.length() && !dq.isEmpty() &&
                        ((str.charAt(i) == ')' && dq.peekLast() == 2)||
                                (str.charAt(i) == ']' && dq.peekLast() == 3))) {
                    dq.pollLast();
                    i++;
                }
            }
            else {
                wrong = true;
                break;
            }
        }

        if (!dq.isEmpty()) wrong  = true;
        System.out.print(wrong ? 0 : res);
    }
}
