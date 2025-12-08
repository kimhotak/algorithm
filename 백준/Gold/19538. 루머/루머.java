import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new List[n+1];
        int tmp;
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (true) {
                tmp = Integer.parseInt(st.nextToken());
                if (tmp == 0) break;
                graph[i].add(tmp);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int[] beliveTime = new int[n+1];
        Arrays.fill(beliveTime, -1);
        int[] nearBeliveCnt = new int[n+1];
        for (int i = 1; i <=n; i++) {
            nearBeliveCnt[i] = (graph[i].size() + 1) >> 1;
        }
        int time = 0;
        
        while (m-- > 0) {
            tmp = Integer.parseInt(st.nextToken());
            dq.addLast(tmp);
            beliveTime[tmp] = 0;
        }

        while (!dq.isEmpty()) {
            time++;
            for (int i = dq.size(); i > 0; i--) {
                int cur = dq.pollFirst();
                for (int next: graph[cur]) {
                    if (beliveTime[next] != -1) continue;
                    if (--nearBeliveCnt[next] <= 0) {
                        beliveTime[next] = time;
                        dq.addLast(next);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(beliveTime[i]).append(' ');
        System.out.print(sb);
    }
}