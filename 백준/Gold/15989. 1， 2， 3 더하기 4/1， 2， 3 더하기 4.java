import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int max = 10001;
        int[] dp = new int[max];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int idx = 4;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (dp[n] == 0) {
                while (idx <= n) {
                    dp[idx] = dp[idx-3] + idx/2 + 1;
                    idx++;
                }
            }
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}