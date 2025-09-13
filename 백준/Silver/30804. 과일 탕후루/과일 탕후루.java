import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[10];
        int kinds = 0, l = 0, res = 0;

        for (int r = 0; r < n; r++) {
            if (cnt[a[r]]++ == 0) kinds++;
            while (kinds > 2) {
                if (--cnt[a[l]] == 0) kinds--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        System.out.print(res);
    }
}