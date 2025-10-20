import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0, right = n-1;
        Long[] res = new Long[2];
        Long value = Long.MAX_VALUE;

        while (left < right) {
            Long sum = arr[left] + arr[right];

            if (value > Math.abs(sum)) {
                value = Math.abs(sum);
                res = new Long[]{arr[left], arr[right]};
            }

            if (sum >= 0) right--;
            else left++;
        }

        sb.append(res[0]).append(' ').append(res[1]);

        System.out.print(sb);
    }
}