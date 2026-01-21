import java.io.*;
import java.util.*;

public class Main {
    public static int[] getLps(char[] str) {
        int[] lps = new int[str.length];

        int i = 1, j = 0;
        while (i < str.length) {
            if (str[i] == str[j]) lps[i++] = ++j;
            else if (j != 0) j = lps[j-1];
            else lps[i++] = 0;
        }

        return lps;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int max = 0;
        for (int s = 0; s < str.length(); s++) {
            int[] lps = getLps(str.substring(s).toCharArray());
            for (int i: lps) max = Math.max(max, i);
        }
        sb.append(max);

        System.out.print(sb);
    }
}