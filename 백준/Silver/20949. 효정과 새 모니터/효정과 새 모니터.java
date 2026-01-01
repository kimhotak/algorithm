import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] ppi = new int[n][2];
        for (int i = 0; i < n; i++) {
            ppi[i][0] = i+1;

            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            ppi[i][1] = w * w + h * h;
        }

        Arrays.sort(ppi, (a,b)->{
            if (a[1]!=b[1]) return b[1]-a[1];
            return a[0]-b[0];
        });

        for (int[] p: ppi) sb.append(p[0]).append('\n');

        System.out.print(sb);
    }
}