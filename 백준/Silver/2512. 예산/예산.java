import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        int m = Integer.parseInt(br.readLine());


        Arrays.sort(arr);

        if (sum <= m) { // 모든 요청 가능
            System.out.print(arr[n-1]);
            return;
        }
        if (arr[0] * n > m) { // 모든 요청 처리 불가능
            System.out.print(m/n);
            return;
        }

        int idx = 1;
        while (idx < n) {
            sum -= (arr[n-idx] - arr[n-idx -1]) * idx;
            if (sum <= m) break;
            idx++;
        }

        sb.append(arr[n-idx-1] + (m-sum) / (idx));

        System.out.print(sb);
    }
}