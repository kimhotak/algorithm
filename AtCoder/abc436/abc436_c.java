import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> place = new HashSet<>();
        int[] d = {-1, 0, 1};
        int cnt = 0;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            boolean flag = false;

            for (int i: d) {
                for (int j: d) {
                    sb = new StringBuilder();
                    sb.append(r+i).append(' ').append(c+j);
                    if (place.contains(sb.toString())) flag = true;
                }
            }

            if (flag) continue;
            sb = new StringBuilder();
            sb.append(r).append(' ').append(c);
            place.add(sb.toString());
            cnt++;
        }

        sb = new StringBuilder();
        sb.append(cnt);
        System.out.print(sb);
    }
}