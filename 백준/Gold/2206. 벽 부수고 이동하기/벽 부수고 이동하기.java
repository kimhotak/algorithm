import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int res = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] grid = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = tmp.charAt(j) == '1';
            }
        }

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        Deque<int[]> dq = new ArrayDeque<>();
        // row, col, cost, passed
        dq.addLast(new int[]{0,0,1,0});

        boolean[][][] visited = new boolean[2][n][m];
        visited[0][0][0] = true;

        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();

            int r = tmp[0], c = tmp[1];
            int cost = tmp[2], passed = tmp[3];
            if (r == n-1 && c == m-1) {
                res = cost;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || n <= nr ||
                    nc < 0 || m <= nc ||
                    visited[passed][nr][nc] ) continue;

                int np = passed;
                if (grid[nr][nc]) {
                    if (np == 1) continue;
                    else np = 1;
                }
                visited[np][nr][nc] = true;
                dq.addLast(new int[]{nr, nc, cost+1, np});
            }
        }

        System.out.print(res == 0 ? -1 : res);
    }
}