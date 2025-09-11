import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MAX = 100001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<Integer>();
        q.addLast(n);
        int[] visited = new int[MAX];
        Arrays.fill(visited, -1);
        visited[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            if (cur == k) break;
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = cur - 1;
                else if (i == 1) next = cur + 1;
                else next = cur * 2;

                if (0 > next || next >= MAX ||
                    visited[next] != -1) continue;
                visited[next] = visited[cur] + 1;

                q.addLast(next);
            }
        }
        System.out.print(visited[k]);
    }
}