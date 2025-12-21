import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] deer = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                deer[i] = w + p;
                sum += p;
            }

            Arrays.sort(deer);
            int idx = 0;
            while (idx < n && sum - deer[idx] >= 0) {
                sum -= deer[idx++];
            }
            sb.append(idx).append('\n');
        }
        
        System.out.print(sb);
    }
}