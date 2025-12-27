import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String S = br.readLine();
        String T = br.readLine();

        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = S.charAt(i) - '0';
        }

        int[] t = new int[n];
        for (int i = 0; i < m; i++) {
            t[i] = T.charAt(i) - '0';
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n - m + 1; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (t[j] > s[i+j]) sum += 10;
                sum += s[i+j] - t[j];
            }
            if (res > sum) res = sum;
        }

        sb.append(res);

        System.out.print(sb);
    }
}