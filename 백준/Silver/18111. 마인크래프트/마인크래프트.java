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

        int[] count = new int[257];
        int minH = 256, maxH = 0;
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                int h = Integer.parseInt(st.nextToken());
                count[h]++;
                if (h < minH) minH = h;
                if (h > maxH) maxH = h;
            }
        }

        int bestTime = Integer.MAX_VALUE;
        int bestH = -1;

        for (int toH = minH; toH <= maxH; toH++) {
            int time = 0;
            int block = b;
            for (int fromH = minH; fromH <= maxH; fromH++) {
                int k = count[fromH];
                if (k == 0) continue;
                int diff = fromH - toH;
                time += (diff < 0 ? -1 : 2) * diff * k;
                block += diff * k;
            }
            if (block < 0) continue;
            if (time <= bestTime) {
                bestTime = time;
                bestH = toH;
            }
        }

        System.out.print(bestTime + " " + bestH);
    }
}