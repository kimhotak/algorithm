import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        int l = 0;
        for (int i = 0; i < n; i++) {
            a[l++] = Integer.parseInt(st.nextToken());
            while (l >= 4 &&
                    a[l-1] == a[l-2] &&
                    a[l-2] == a[l-3] &&
                    a[l-3] == a[l-4] ) {
                l -= 4;
            }
        }

        sb.append(l);

        System.out.print(sb);
    }
}