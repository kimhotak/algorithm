import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] grid = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = grid[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        int[][] num = new int[m][4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            int[] t = num[i];
            int x1 = t[0], y1 = t[1];
            int x2 = t[2], y2 = t[3];

            int sum = 0;
            for (int x = x1-1; x < x2; x++) {
                sum += grid[x][y2] - grid[x][y1-1];
            }

            sb.append(sum).append('\n');
        }



        System.out.print(sb);
    }
}