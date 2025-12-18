
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int m = 100000;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] time = new int[m+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[n] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{n, 0});

        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            if (time[cur[0]] < cur[1]) continue;
            
            for (int j = -1; j <=1; j++) {
                int next = cur[0] + j;
                int nextTime = time[cur[0]] + 1;
                if (j == 0) {
                    next *= 2;
                    nextTime--;
                }
                
                if (m >= next && next >= 0 && time[next] > nextTime) {
                    time[next] = nextTime;
                    pq.offer(new int[]{next, time[next]});
                }
            }
        }

        sb.append(time[k]);
        System.out.print(sb);
    }
}