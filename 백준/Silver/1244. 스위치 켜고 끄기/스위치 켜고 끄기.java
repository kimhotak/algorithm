import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] swich = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            swich[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (s == 1) {
                for (int i = num; i <= n; i += num) {
                    swich[i] ^= 1;
                }
            }
            else {
                swich[num] ^= 1;
                int l = num-1, r = num+1;
                while (0 < l && r <= n && swich[l] == swich[r]) {
                    swich[l--] ^= 1;
                    swich[r++] ^= 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(swich[i]).append(' ');
            if (i % 20 == 0) sb.append('\n');
        }


        System.out.print(sb);
    }
}