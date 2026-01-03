import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = (int) Math.pow(n, 0.5) + 1;
        int[] used = new int[n+1];

        for (int x = 1; x <= m; x++) {
            for (int y = x + 1; y <= m; y++) {
                int tmp = x*x + y*y;
                if (tmp > n) break;
                used[tmp]++;
            }
        }

        int cnt = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (used[i] == 1) {
                cnt++;
                tmp.append(i).append(' ');
            }
        }
        sb.append(cnt).append('\n');
        sb.append(tmp);

        System.out.print(sb);
    }
}