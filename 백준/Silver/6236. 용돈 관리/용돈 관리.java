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
        long hi = 0;
        long lo = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            hi += arr[i];
            lo = Math.max(lo, arr[i]);
        }

        while (lo <= hi) {
            long k = (lo + hi) / 2;

            int cnt = 1; // 인출 횟수
            long money = k;
            for (int use: arr) {
                if (money >= use) {
                    // 통장에서 뺀 돈으로 하루를 보낼 수 있으면 그대로 사용하고
                    money -= use;
                }
                else {
                    // 모자라게 되면 남은 금액은 통장에 집어넣고 다시 K원을 인출한다.
                    cnt++;
                    money = k - use;
                }
            }

            if (cnt <= m) hi = k - 1;
            else lo = k + 1;
        }

        sb.append(lo);

        System.out.print(sb);
    }
}