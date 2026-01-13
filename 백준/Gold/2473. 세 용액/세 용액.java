import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] r = new int[3];
        long res = Long.MAX_VALUE;
        for (int x = 0; x < n; x++) {
            int y = x + 1, z = n - 1;
            while (y < z) {
                long sum = arr[x] + arr[y] + arr[z];
                long absSum = Math.abs(sum);

                if (res > absSum) {
                    res = absSum;
                    r[0] = x;
                    r[1] = y;
                    r[2] = z;
                }

                if (sum > 0) z--;
                else y++;
            }
        }
        for (int i: r) sb.append(arr[i]).append(' ');

        System.out.print(sb);
    }
}