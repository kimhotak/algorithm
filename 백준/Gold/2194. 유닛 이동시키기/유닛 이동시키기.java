import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        int r, c;
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            grid[r][c] = -1;
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        dq.addLast(new int[]{r,c}); // 시작점
        
        st = new StringTokenizer(br.readLine());
        int goalr = Integer.parseInt(st.nextToken()) - 1;
        int goalc = Integer.parseInt(st.nextToken()) - 1;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            r = cur[0];
            c = cur[1];
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || n <= nr + a - 1 ||
                    nc < 0 || m <= nc + b - 1 ||
                    grid[nr][nc] != 0) continue;
                boolean errorFlag = false;
                if (i == 0) {
                    for (int j = 0; j < b; j++) {
                        if (grid[nr][nc + j] == -1) errorFlag = true;
                    }
                }
                else if (i == 1) {
                    for (int j = 0; j < b; j++) {
                        if (grid[r + a][nc + j] == -1) errorFlag = true;
                    }
                }
                else if (i == 2) {
                    for (int j = 0; j < a; j++) {
                        if (grid[nr + j][nc] == -1) errorFlag = true;
                    }
                }
                else if (i == 3) {
                    for (int j = 0; j < a; j++) {
                        if (grid[nr + j][c + b] == -1) errorFlag = true;
                    }
                }

                if (errorFlag) {
                    grid[nr][nc] = -2;
                    continue;
                }
                grid[nr][nc] = grid[r][c] + 1;
                dq.addLast(new int[]{nr, nc});
            }
            if (grid[goalr][goalc] != 0) break;
        }
        
        

        
        StringBuilder sb = new StringBuilder();
        // for (int[] g: grid) sb.append(Arrays.toString(g)).append('\n');
        sb.append(grid[goalr][goalc] == 0 ? -1 : grid[goalr][goalc]);
        System.out.print(sb);
    }
}