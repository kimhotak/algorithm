import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long lo = 1, hi = (long) arr[0] * m;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long passed = 0;
            for (int i: arr) {
                passed += mid/i;
            }
            if (passed >= m) hi = mid - 1;
            else lo = mid + 1;
        }

        sb.append(lo);

        System.out.print(sb);
    }
}