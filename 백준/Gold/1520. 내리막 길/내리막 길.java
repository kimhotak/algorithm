import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] grid;
    static int[][] dp;
    static final int[] dy = {0,0,-1,1}, dx = {-1,1,0,0};

    static int dfs(int y, int x) {
        if (y == m-1 && x == n-1) return 1;
        if (dp[y][x] != -1) return dp[y][x];
        int ways = 0;
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k], nx = x + dx[k];
            if (ny < 0 || m <= ny ||
                nx < 0 || n <= nx ||
                grid[ny][nx] >= grid[y][x]) continue;

            ways += dfs(ny, nx);
        }
        return dp[y][x] = ways;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        grid = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(dp[i], -1);
        }
        
        System.out.print(dfs(0,0));
    }
}