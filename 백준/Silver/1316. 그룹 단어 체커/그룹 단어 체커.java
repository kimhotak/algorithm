import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int res = 0;

        while (n-- > 0) {
            boolean flag = false;
            boolean[] alpha = new boolean[(int)'z'+ 1];
            char[] s = br.readLine().toCharArray();
            alpha[s[0]] = true;
            for (int i = 1; i < s.length; i++) {
                if (s[i] == s[i-1]) continue;

                if (alpha[s[i]]) {
                    flag = true;
                    break;
                }
                else alpha[s[i]] = true;
            }
            if (!flag) res++;

        }

        sb.append(res);

        System.out.print(sb);
    }
}