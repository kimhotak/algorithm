import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        // row, col, cost( 벽넘으면 음수)
        dq.addLast(new int[]{0,0,0});
        while (!dq.isEmpty()) {
            int[] tmp = dq.pollFirst();
            int row = tmp[0], col = tmp[1], cost = tmp[2];


        }
    }
}