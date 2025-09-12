import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, 4);
        for (int i = 1; Math.pow(i, 2) <= n; i++) {
            dp[(int) Math.pow(i, 2)] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] == 1) continue;
            for (int j = 1; j <= i/2; j++) {
                if (dp[i] > dp[j] + dp[i-j]) dp[i] = dp[j] + dp[i-j];
                if (dp[i] <= 2) break;
            }
        }
        System.out.print(dp[n]);
    }
}