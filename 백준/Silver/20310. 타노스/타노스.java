import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] s = br.readLine().toCharArray();

        int cnt0 = 0, cnt1 = 0;
        for (char c: s) {
            if (c == '1') cnt1++;
            else cnt0++;
        }

        cnt0 /= 2;
        cnt1 /= 2;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '1') {
                s[i] = ' ';
                cnt1--;
            }
            if (cnt1 == 0) break;
        }

        for (int i = s.length-1; i > 0; i--) {
            if (s[i] == '0') {
                s[i] = ' ';
                cnt0--;
            }
            if (cnt0 == 0) break;
        }

        for (char c: s) {
            if (c != ' ') sb.append(c);
        }

        System.out.print(sb);
    }
}