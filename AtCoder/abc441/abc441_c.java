import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int alchol = 0;
        int water = n - k;
        for (int i = k - 1; i >= 0; i--) {
            x -= arr[i];
            alchol++;
            if (x <= 0) break;
        }

        sb.append(x > 0 ? -1 : alchol + water);
        System.out.print(sb);
    }
}