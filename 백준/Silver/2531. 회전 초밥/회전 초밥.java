import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d+1];
        int cnt = 0;
        for (int i = 0; i < k-1; i++) {
            if (sushi[belt[i]]++ == 0) cnt++;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sushi[belt[(i+k-1)%n]]++ == 0) cnt++;

            res = Math.max(res, cnt + (sushi[c]==0? 1:0));

            if (--sushi[belt[i]] == 0) cnt--;
        }

        sb.append(res);

        System.out.print(sb);
    }
}