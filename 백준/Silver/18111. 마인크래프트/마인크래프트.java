import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] ground = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                ground[r][c] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.print(255*500*500);
//        63_750_000 완탐 가능?
        int[] times = new int[257];
        int[] blocks = new int[257];
        for (int h = 0; h <= 256; h++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    int dif = ground[r][c] - h;
                    times[h] += dif < 0 ? -dif : 2 * dif;
                    blocks[h] += dif;
                }
            }
        }

        int res = 0;
        for (int h = 0; h <= 256; h++) {
            if (b + blocks[h] < 0) continue;
            if (times[res] >= times[h]) res = h;
        }
        sb.append(times[res]).append(' ').append(res);
        System.out.print(sb);
    }
}