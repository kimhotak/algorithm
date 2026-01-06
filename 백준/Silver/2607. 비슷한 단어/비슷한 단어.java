import java.io.*;
import java.util.*;

public class Main {
    public static int[] alphaCount(String str) {
        int[] alpha = new int[26];
        for (char c: str.toCharArray()) {
            alpha[c-'A']++;
        }
        return alpha;
    }

    public static boolean isSimilar(int[] a, int[] b) {
        int p = 0, m = 0;
        for (int i = 0; i < 26; i++) {
            int tmp = a[i] - b[i];

            if (tmp > 0) p += tmp;
            else if (tmp < 0) m -= tmp;
        }
        return p <= 1 && m <= 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int[] standard = alphaCount(br.readLine());
        for (int i = 1; i < n; i++) {
            int[] compare = alphaCount(br.readLine());
            if (isSimilar(standard, compare)) res++;
        }
        sb.append(res);

        System.out.print(sb);
    }
}