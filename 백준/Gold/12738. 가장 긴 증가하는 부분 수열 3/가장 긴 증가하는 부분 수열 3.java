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

        List<Integer> tail = new ArrayList<>();
        tail.add(a[0]);

        for (int i = 1; i < n; i++) {
            int left = 0, right = tail.size() - 1;
            if(a[i] > tail.get(right)) {
                tail.add(a[i]);
                continue;
            }

            while (left < right) {
                int mid = (left + right) / 2;
                if (a[i] > tail.get(mid)) left = mid+1;
                else right = mid;
            }
            tail.set(right, a[i]);
        }

        System.out.print(tail.size());
    }
}