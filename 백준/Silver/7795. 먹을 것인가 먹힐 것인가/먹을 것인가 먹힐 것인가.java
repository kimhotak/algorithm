import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);

            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(b);

            int res = 0;
            int ai = n - 1, bi = m - 1;
            while (ai >= 0 && bi >= 0) {
                while (bi >= 0 && a[ai] <= b[bi]) bi--;
                res += bi + 1;
                ai--;
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}