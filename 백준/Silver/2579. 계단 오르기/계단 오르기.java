import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n];
        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        sb.append(solution(n, stair));

        System.out.print(sb);
    }

    public static int solution(int n, int[] s) {
        int result = 0;
        int[][] dp = new int[n + 1][2];
        // 0: 이전칸 건너 뛴 경우
        // 1: 이전칸 연속해서 밟은 경우
        Arrays.fill(dp[1], s[0]);
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-2][0] + s[i-1], dp[i-2][1] + s[i-1]);
            dp[i][1] = Math.max(dp[i-1][0] + s[i-1], dp[i][1]);
        }
        result = Math.max(dp[n][0], dp[n][1]);
        return result;
    }
}