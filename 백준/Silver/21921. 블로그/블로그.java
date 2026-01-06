import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[x];
        int idx = 0, sum = 0;
        int max = 0, cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum -= arr[idx];
            arr[idx] = Integer.parseInt(st.nextToken());
            sum += arr[idx];
            idx = (idx + 1) % x;
            if (i < x) continue;
            if (sum > max) {
                max = sum;
                cnt = 1;
            }
            else if (sum == max) {
                cnt++;
            }
        }

        if (sum != 0) sb.append(max).append('\n').append(cnt);
        else sb.append("SAD");

        System.out.print(sb);
    }
}