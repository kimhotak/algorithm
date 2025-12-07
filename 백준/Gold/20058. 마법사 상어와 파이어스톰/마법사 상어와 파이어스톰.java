import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int q = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<int[]> queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        while (q-- > 0) {
            int l = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
            // rotate
            int[][] tmp = new int[l][l];
            for (int lr = 0; lr < n; lr+= l) {
                for (int lc = 0; lc < n; lc+= l) {
                    for (int sr = 0; sr < l; sr++) {
                        for (int sc = 0; sc < l; sc++) {
                            tmp[sr][sc] = grid[lr+sr][lc+sc];
                        }
                    }

                    for (int sr = 0; sr < l; sr++) {
                        for (int sc = 0; sc < l; sc++) {
                            grid[lr+sr][lc+sc] = tmp[l -1-sc][sr];
                        }
                    }
                }
            }

            // melt
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int iceCount = 4;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i], nc = c + dc[i];
                        if (nr < 0 || n <= nr ||
                                nc < 0 || n <= nc ||
                                grid[nr][nc] == 0) iceCount--;
                    }
                    if (iceCount < 3 && grid[r][c] != 0){
                        queue.add(new int[]{r,c});
                    }
                }
            }
            while (!queue.isEmpty()) {
                int[] meltPoint = queue.poll();
                grid[meltPoint[0]][meltPoint[1]]--;
            }

        }

        boolean[][] visited = new boolean[n][n];
        int allIce = 0;
        int bigIce = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                allIce += grid[r][c];

                if (visited[r][c] || grid[r][c] == 0) continue;
                int curIce = 1;
                queue.add(new int[]{r,c});
                visited[r][c] = true;
                while (!queue.isEmpty()) {
                    int[] tmp = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = tmp[0] + dr[i], nc = tmp[1] + dc[i];
                        if (nr < 0 || n <= nr ||
                            nc < 0 || n <= nc ||
                            grid[nr][nc] == 0 ||
                            visited[nr][nc]) continue;
                        queue.add(new int[]{nr,nc});
                        visited[nr][nc] = true;
                        curIce++;
                    }
                }
                bigIce = Math.max(bigIce, curIce);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(allIce).append('\n').append(bigIce);
        System.out.print(sb);
    }
}