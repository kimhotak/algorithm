import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> tail = new ArrayList<>();
        tail.add(a[0]);

        for (int i = 1; i < n; i++) {
            int lo = 0, hi = tail.size() - 1;
            if(a[i] > tail.get(hi)) {
                tail.add(a[i]);
                continue;
            }

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (a[i] > tail.get(mid)) lo = mid + 1;
                else hi = mid - 1;
            }
            tail.set(lo, a[i]);
        }

        sb.append(tail.size());

        System.out.print(sb);
    }
}