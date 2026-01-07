import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] name = new String[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int low = 0, high = n-1;
            int mid;
            while (low < high) {
                mid = (low + high) / 2;
                if (value[mid] >= power) high = mid;
                else low = mid + 1;
            }

            sb.append(name[low]).append('\n');
        }

        System.out.print(sb);
    }
}