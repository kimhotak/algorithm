import java.io.*;
import java.util.*;

public class Main {
    public static int bs(int[] arr, int n) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == n) {
                return 1;
            }
            else if (arr[mid] > n) hi = mid - 1;
            else lo = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (m-- > 0) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(bs(arr, num)).append('\n');
            }
        }

        System.out.print(sb);
    }
}