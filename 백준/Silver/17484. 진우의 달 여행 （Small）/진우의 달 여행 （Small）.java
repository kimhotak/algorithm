import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int n, m;
    static int res = Integer.MAX_VALUE;
    static int now = 0;

    public static void dfs(int r, int c, int bfrDir) {
        if (r+1 == n) {
            res = Math.min(res, now + grid[r][c]);
            return;
        }
        now += grid[r][c];
        for (int dir = -1; dir <= 1; dir++) {
            if (c == 0 && dir == -1) continue;
            if (c == m-1 && dir == 1) continue;
            if (dir == bfrDir) continue;
            dfs(r+1,c+dir, dir);
        }
        now -= grid[r][c];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            dfs(0,i,3);
        }

        sb.append(res);

        System.out.print(sb);
    }
}