import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long lo = 1, hi = 1_000_000_000;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long cnt = 0;
            for (int len: arr) {
                cnt += len / mid;
            }
            if (cnt >= m) lo = mid + 1;
            else hi = mid - 1;
        }
        sb.append(hi);

        System.out.print(sb);
    }
}