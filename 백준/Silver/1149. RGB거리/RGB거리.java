import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] += Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
            }
        }

        System.out.print(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));

    }
}