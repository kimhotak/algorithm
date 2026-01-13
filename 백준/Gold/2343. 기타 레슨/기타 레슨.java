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
        st = new StringTokenizer(br.readLine());
        long lo = 0, hi = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (isEnterAble(arr, m, mid)) hi = mid - 1;
            else lo = mid + 1;
        }

        sb.append(lo);

        System.out.print(sb);
    }

    public static boolean isEnterAble(int[] arr, int m, long size) {
        int cnt = 1;
        long sum = 0;
        for (int num: arr) {
            if (sum + num > size) {
                sum = num;
                cnt++;
                if (cnt > m) return false;
            }
            else sum += num;
        }
        return true;
    }
}