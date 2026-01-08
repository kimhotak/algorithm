import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i][0] = i + 1;
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Comparator.comparingInt(a->a[1]));

            int last = 0;
            long res = 0L;
            for (int i = n-1; i >= 0; i--) {
                if (arr[i][0] > last) {
                    res += (long) arr[i][1] * (arr[i][0] - last - 1);
                    last = arr[i][0];
                }
                else {
                    res -= arr[i][1];
                }
            }
            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }
}