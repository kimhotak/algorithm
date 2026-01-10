import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = i+1;
        }

        Arrays.sort(arr, Comparator.comparingInt(a->a[0]));

        for (int i = 0; i < 3; i++) {
            sb.append(arr[i][1]).append(' ');
        }


        System.out.print(sb);
    }
}