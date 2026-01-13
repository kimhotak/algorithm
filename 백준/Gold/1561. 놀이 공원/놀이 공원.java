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
        if (n <= m) {
            System.out.print(n);
            return;
        }

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long lo = 1, hi = (long)n * 30;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long rided = m;
            for (int i = 0; i < m; i++) {
                rided += mid / arr[i];
                if (rided >= n) break;
            }
            if (rided >= n) hi = mid - 1;
            else lo = mid + 1;
        }
        long time = lo;

        // lo가 다 탈수 있는 시간
        // lo-1 은 일부 못타는 시간
        // 이 사이에 마지막 아이가 탐
        // lo-1 부터 1단위시간 시뮬레이션

        long rided = m; // 탄 아이 수
        for (int i = 0; i < m; i++) {
            rided += (time-1) / arr[i];
        }
        
        for (int i = 0; i < m; i++) {
            if (time % arr[i] == 0) {
                rided++;
                if (rided == n) {
                    sb.append(i+1);
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}