import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] open = new int[10];
        int[] close = new int[10];
        int len = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                open[len] = i;
                stack.addLast(len++);
            }
            else if (str[i] == ')') {
                close[stack.pollLast()] = i;
            }
        }


        List<char[]> m = new ArrayList<>();
        m.add(str);
        for (int i = 0; i < len; i++) {
            List<char[]> tmp = new ArrayList<>();
            for (char[] c : m) {
                tmp.add(c);
                char[] nc = c.clone();
                nc[open[i]] = ' ';
                nc[close[i]] = ' ';
                tmp.add(nc);
            }
            m = tmp;
        }
        m.remove(0);


        Set<String> r = new HashSet<>();
        for (char[] s : m) {
            StringBuilder sb = new StringBuilder();
            for (char c : s) {
                if (c != ' ') sb.append(c);
            }
            r.add(sb.toString());
        }

        List<String> res = new ArrayList<>(r);
        res.sort((a,b) -> {
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String s: res) sb.append(s).append('\n');
        System.out.print(sb);
    }
}