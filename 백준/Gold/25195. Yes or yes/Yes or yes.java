import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] edge = new List[n+1];
        for (int i = 0; i <= n; i++) edge[i] = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edge[u].add(v);
        }
        edge[0].add(1);

        int s = Integer.parseInt(br.readLine());
        Set<Integer> fan = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) fan.add(Integer.parseInt(st.nextToken()));

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n+1];
        stack.add(0);
        String res = "Yes";

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (edge[cur].isEmpty()) {
                res = "yes";
                break;
            }
            for (int next: edge[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                if (!fan.contains(next)) stack.add(next);
            }
        }

        System.out.print(res);
    }
}