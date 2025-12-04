import java.io.*;
import java.util.*;

public class Main {
    static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cols = Integer.parseInt(st.nextToken());
            int rows = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] grid = new boolean[rows][cols];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                grid[r][c] = true;
            }

            int bugCount = 0;
            Deque<int[]> q = new ArrayDeque<>();

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (!grid[r][c]) continue;

                    bugCount++;
                    grid[r][c] = false;
                    q.addLast(new int[]{r, c});
                    
                    while (!q.isEmpty()) {
                        int[] cur = q.pollFirst();
                        int cr = cur[0], cc = cur[1];
                        for (int[] d : DIRS) {
                            int nr = cr + d[0];
                            int nc = cc + d[1];

                            if (0 > nr || nr >= rows ||
                                0 > nc || nc >= cols ||
                                !grid[nr][nc]) continue;

                            grid[nr][nc] = false;
                            q.addLast(new int[]{nr, nc});
                        }
                    }
                }
            }
            sb.append(bugCount).append('\n');
        }
        System.out.print(sb);
    }
}