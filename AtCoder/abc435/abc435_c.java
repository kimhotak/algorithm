import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int fall = arr[1];
        for (int i = 1; i <= n; i++) {
            if (fall < i) break;
            if (i + arr[i] - 1 > fall) fall = i + arr[i] - 1;
        }

        sb.append(Math.min(fall,n));
        System.out.print(sb);
    }
}