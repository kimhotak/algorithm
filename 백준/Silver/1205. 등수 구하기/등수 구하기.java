import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());


        int[] arr = new int[n+1];
        if (n != 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n] = score;

        Arrays.sort(arr);

        int res = -1;
        if (p > n || arr[n-p] != score) {
            for (int i = 0; i < p; i++) {
                if (arr[n - i] == score) {
                    res = i + 1;
                    break;
                }
            }
        }
        sb.append(res);

        System.out.print(sb);
    }
}