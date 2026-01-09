import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder t;
    static String s;

    public static boolean dfs() {
        if (t.length() == s.length()) {
            return t.toString().equals(s);
        }

        boolean flag = false;
        if (t.charAt(t.length()-1) == 'A') {
            t.deleteCharAt(t.length()-1);
            flag = dfs();
            if (flag) return flag;
            t.append('A');
        }

        if (t.charAt(0) == 'B') {
            t.deleteCharAt(0);
            t.reverse();
            flag = dfs();
            t.append('B');
            t.reverse();
        }

        return flag;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        s = br.readLine();
        t = new StringBuilder(br.readLine());

        sb.append(dfs() ? 1 : 0);

        System.out.print(sb);
    }
}