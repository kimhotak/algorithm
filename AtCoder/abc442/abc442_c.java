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

        int[] arr = new int[n+1]; //1-index
        Arrays.fill(arr, n-1); // 자신제외

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]--; // 관계 제외
            arr[b]--; // 관계 제외
        }

        for (int i = 1; i <= n; i++) {
            sb.append(comb(arr[i])).append(' ');
        }

        System.out.print(sb);
    }

    public static long comb(int n) {
        if (n < 3) return 0;
        return ((long) n * (n - 1) * (n - 2)) / 6;
    }
}