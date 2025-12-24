import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] nge = new int[n];
        Arrays.fill(nge, -1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->arr[a]-arr[b]);

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && arr[i] > arr[pq.peek()]) {
                nge[pq.poll()] = arr[i];
            }
            pq.offer(i);
        }

        for (int i: nge) sb.append(i).append(' ');

        System.out.print(sb);
    }
}