import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 5;
            for (int j = 1; j*j <= i; j++) {
                if (dp[i] > dp[i - j*j]) dp[i] = dp[i - j*j];
            }
            dp[i]++;
        }
        System.out.print(dp[n]);
    }
}