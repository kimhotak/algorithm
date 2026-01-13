import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long z = 100 * y / x;
        if (z >= 99) {
            System.out.print(-1);
            return;
        }

        long lo = 0, hi = 1_000_000_000;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (100 * (y + mid) / (x + mid) > z) hi = mid - 1;
            else lo = mid + 1;
        }

        sb.append(lo);

        System.out.print(sb);
    }
}