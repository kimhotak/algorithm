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

        // 보석 무게순 오름차순
        int[][] jewel = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jewel, (a, b)->a[0]-b[0]);

        // 가방 무게순 오름차순
        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b)-> b-a);

        int bi = 0, ji = 0;
        long value = 0; // 최대 값 300,000,000,000
        while (bi < k) {
            while (ji < n && jewel[ji][0] <= bags[bi]) {
                pq.offer(jewel[ji++][1]);
            }
            if (!pq.isEmpty()) value += pq.poll();
            bi++;
        }

        sb.append(value);
        System.out.print(sb);
    }
}