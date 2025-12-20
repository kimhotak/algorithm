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
        int n = Integer.parseInt(st.nextToken());

        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] res = new int[h];
        for (int i = 0; i < n; i++) {
            int b = Integer.parseInt(br.readLine());
            for (int j = 0; j < h; j++) {
                for (int g: grid[j]) {
                    if (g == b) res[j]++;
                }
            }
        }

        int max = 0;
        for (int r: res) max = Math.max(max, r);
        sb.append(max);
        
        System.out.print(sb);
    }
}