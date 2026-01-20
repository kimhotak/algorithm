import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[][] memo;

    public static void dfs(int node, int cost, int visited, int depth) {
        for (int next = 0; next < n; next++) {
            int nextCost = graph[node][next];
            int nextVisited = visited | 1 << next;
            if (cost > nextCost || (visited & (1 << next)) != 0) continue;
            if (memo[nextVisited][next] <= nextCost) continue;
            memo[nextVisited][next] = nextCost;
            dfs(next, nextCost, nextVisited,depth+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        memo = new int[1 << n][n];// 상태, 마지막
        for (int i = 0; i < 1 <<n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                graph[i][j] = str[j] - '0';
            }
        }

        dfs(0, 0, 1 << 0, 1);

        int res = 0;
        for (int i = 0; i < 1<<n; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == Integer.MAX_VALUE) continue;
                res = Math.max(res, Integer.bitCount(i));
            }
        }
        sb.append(res);

        System.out.print(sb);
    }
}