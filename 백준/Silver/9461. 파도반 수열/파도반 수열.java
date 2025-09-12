import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] testCase = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
            max = Math.max(testCase[i], max);
        }
        long[] dp = new long[max];
        for (int i = 0; i < 3; i++) dp[i] = 1;
        for (int i = 3; i < max; i ++) dp[i] = dp[i-2] + dp[i-3];

        for (int tc: testCase) {
            sb.append(dp[tc-1]).append('\n');
        }
        System.out.print(sb);
    }
}