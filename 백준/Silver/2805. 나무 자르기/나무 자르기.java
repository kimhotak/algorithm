import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 1_000_000_000;
        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            long sum = 0;
            for (int tree: trees) {
                if (tree > mid) sum += tree - mid;
            }

            if (sum < m) high = mid - 1;
            else {
                res = mid;
                low = mid + 1;
            }
        }
        System.out.print(res);
    }
}