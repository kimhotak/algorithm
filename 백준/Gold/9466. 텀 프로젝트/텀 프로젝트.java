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
            arr = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n+1];
            finished = new boolean[n+1];
            res = n;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            sb.append(res).append('\n');
        }



        System.out.print(sb);
    }


    static int res;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;

    public static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) { // 일반
            dfs(next);
        }
        else if (!finished[next]) { // 사이클
            for (int node = next; node != cur; node = arr[node]) {
                res--;
            }
            res--; // cur
        }
        finished[cur] = true;
    }
}