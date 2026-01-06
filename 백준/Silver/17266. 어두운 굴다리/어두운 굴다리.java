import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int max = 0, bfr = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (i == 0) {
                max = Math.max(max, x - bfr);
            }
            else {
                max = Math.max(max, (int)Math.ceil((double)(x - bfr) / 2));
            }
            bfr = x;
        }
        max = Math.max(max, n - bfr);
        sb.append(max);

        System.out.print(sb);
    }
}