import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] res = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            int num = arr[i];
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            while (!visited[num]) {
                visited[num] = true;
                num = arr[num];
            }

            if (num == i) {
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) res[j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (res[i]) cnt++;
        }
        sb.append(cnt);
        for (int i = 1; i <= n; i++) {
            if (res[i]) sb.append('\n').append(i);
        }

        System.out.print(sb);
    }
}