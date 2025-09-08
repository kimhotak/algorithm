import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] m = new int[n][2];
            for (int i = 0; i < n; i ++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    m[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(m, (a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                else return Integer.compare(a[0], b[0]);
            });

            int res = 0;
            int last = n + 1;
            for (int i = 0; i < n; i++) {
                if (m[i][1] < last) {
                    last = m[i][1];
                    res += 1;
                }
            }

            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}