import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] tail = new int[n];
        int len = 0;
        tail[len++] = 0;

        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        for (int i = 1; i < n; i++) {
            int left = 0, right = len - 1;

            if (a[i] > a[tail[right]]) {
                prev[i] = tail[len-1];
                tail[len++] = i;
                continue;
            }

            while (left < right) {
                int mid = (left + right) / 2;
                if (a[i] > a[tail[mid]]) left = mid+1;
                else right = mid;
            }
            prev[i] = right == 0 ? -1 : tail[right-1];
            tail[right] = i;
        }

        sb.append(len).append('\n');
        int idx = tail[len - 1];
        Deque<Integer> dq = new ArrayDeque<>();
        while (idx != -1) {
            dq.addLast(idx);
            idx = prev[idx];
        }
        while (!dq.isEmpty()) {
            int tmp = dq.pollLast();
            sb.append(a[tmp]).append(' ');
        }
        System.out.print(sb);
    }
}