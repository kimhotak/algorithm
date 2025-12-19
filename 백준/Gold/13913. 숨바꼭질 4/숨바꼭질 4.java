import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = 100000;
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(n);
        int[] visited = new int[m+1];
        Arrays.fill(visited, -1);
        visited[n] = -2;

        int time = 0;
        int cnt = 0;
        boolean findFlag = false; 
        while (!dq.isEmpty() && !findFlag) {
            for (int i = dq.size(); i > 0; i--) {
                int cur = dq.pollFirst();
                if (cur == k) {
                    findFlag = true;
                    cnt++;
                }
                for (int j = -1; j <= 1; j++) {
                    int next = cur + j;
                    if (j == 0) next *= 2;
                    if (next < 0 || m < next ||
                       visited[next] != -1) continue;
                    dq.addLast(next);
                    visited[next] = cur;
                }
            }
            if (!findFlag) time++;
        }

        sb.append(time).append('\n');

        int[] res = new int[time+1];
        for (int i = time; i >= 0 ; i--) {
            res[i] = k;
            k = visited[k];
        }
        for (int r: res) {
            sb.append(r).append(' ');
        }
        
        System.out.print(sb);
    }
}