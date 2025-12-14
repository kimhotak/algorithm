import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] grid = new char[h][w];

        for (int i = 0; i < h; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        List<int[]>[] warpCell = new ArrayList[26];
        for (int i = 0; i < 26; i++) warpCell[i] = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ('a' <= grid[i][j] && grid[i][j] <= 'z') {
                    warpCell[grid[i][j] - 'a'].add(new int[]{i,j});
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dist = new int[h][w];
        for (int[] d: dist) Arrays.fill(d, -1);
        dq.addLast(new int[]{0,0});
        dist[0][0] = 0;
        int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];
            if (r == h - 1 && c == w - 1) break;
            // walk
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || h <= nr ||
                    nc < 0 || w <= nc ||
                    grid[nr][nc] == '#' ||
                    dist[nr][nc] != -1) continue;
                dq.addLast(new int[]{nr, nc});
                dist[nr][nc] = dist[r][c] + 1;
            }
            // warp
            if ('a' <= grid[r][c] && grid[r][c] <= 'z') {
                int curIndex = grid[r][c] - 'a';
                for (int[] next: warpCell[curIndex]) {
                    int nr = next[0], nc = next[1];
                    if (dist[nr][nc] != -1) continue;
                    dq.addLast(next);
                    dist[nr][nc] = dist[r][c] + 1;
                }
                warpCell[curIndex].clear();
            }
        }

        sb.append(dist[h -1][w -1] == 0 ? -1 : dist[h -1][w -1]);
        System.out.print(sb);
    }
}