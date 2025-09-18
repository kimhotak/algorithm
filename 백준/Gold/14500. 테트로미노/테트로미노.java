import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                visited[r][c] = true;
                res = Math.max(res, dfs(r, c, 1, arr[r][c]));
                visited[r][c] = false;
                res = Math.max(res, checkT(r, c));
            }
        }
        System.out.print(res);
    }

    static int dfs(int r, int c, int depth, int sum) {
        if (depth == 4) return sum;
        int best = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            best = Math.max(best, dfs(nr, nc, depth + 1, sum + arr[nr][nc]));
            visited[nr][nc] = false;
        }
        return best;
    }

    static int checkT(int r, int c) {
        int center = arr[r][c];
        int cnt = 0, adjSum = 0, minAdj = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++ ) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
            cnt++;
            adjSum += arr[nr][nc];
            minAdj = Math.min(minAdj, arr[nr][nc]);
        }

        if (cnt < 3) return 0;
        if (cnt == 3) return center + adjSum;
        return center + adjSum - minAdj;
    }
}
