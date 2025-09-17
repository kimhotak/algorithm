import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                path.add(new int[]{r,c});
                res = Math.max(res, dfs(r,c,arr[r][c]));
                path.remove(new int[]{r,c});
            }
        }
        System.out.print(res);
    }
    static int n;
    static int m;
    static int[][] arr;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static Set<int[]> path = new HashSet<>();

    static int dfs(int r, int c, int score) {
        if (path.size() >= 4) return score;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || n <= nr ||
                    nc < 0 || m <= nc ||
                    path.contains(new int[]{nr,nc})) continue;

            path.add(new int[]{nr,nc});
            res = Math.max(res, dfs(nr, nc, score + arr[nr][nc]));
            path.remove(new int[]{nr,nc});
        }
        return res;
    }
}