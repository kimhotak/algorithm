import java.io.*;
import java.util.*;

public class Main {
    static int[][] grid;
    static int n, m, res = 0;
    static int[] dy = {0,0,-1,1}, dx = {-1,1,0,0};

    public static void dfs(int r, int c, int wall) {
        if (wall >= 3) {
            bfs();
            return;
        }
        if (c >= m) {
            r++;
            c = 0;
        }
        if (r >= n) return;

        if (grid[r][c] == 0) {
            grid[r][c] = -1;
            dfs(r, c+1, wall+1);
            grid[r][c] = 0;
        }
        dfs(r, c+1, wall);
        return;
    }

    public static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 2) {
                    dq.addLast(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int cy = cur[0], cx = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i], nx = cx + dx[i];
                if (ny < 0 || n <= ny ||
                    nx < 0 || m <= nx ||
                    grid[ny][nx] != 0 ||
                    visited[ny][nx]) continue;
                dq.addLast(new int[]{ny,nx});
                visited[ny][nx] = true;
            }
        }

        int sum = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0 && !visited[r][c]) {
                    sum++;
                }
            }
        }
        res = Math.max(res,sum);
        return;
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

        dfs(0,0,0);
        sb.append(res);

        System.out.print(sb);
    }
}