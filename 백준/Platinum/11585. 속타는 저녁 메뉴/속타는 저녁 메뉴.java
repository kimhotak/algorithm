import java.io.*;
import java.util.*;

public class Main {
    public static int[] getLps(char[] str) {
        int[] res = new int[str.length];
        int i = 1, j = 0;
        while (i < res.length) {
            if (str[i] == str[j]) res[i++] = ++j;
            else if (j != 0) j = res[j-1];
            else res[i++] = 0;
        }
        return res;
    }

    public static int kmpCounter(char[] str, char[] pattern) {
        int res = 0;
        int[] lps = getLps(pattern);
        int i = 0, j = 0;
        while (i < str.length) {
            if (str[i] == pattern[j]) {
                j++;
                i++;
                if (j == pattern.length) {
                    res++;
                    j = lps[j-1];
                }
            }
            else if (j != 0) j = lps[j-1];
            else i++;
        }
        return res;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        char[] pattern = new char[n];
        char[] text = new char[n + n-1];
        for (int i = 0; i < n; i++) {
            pattern[i] = st.nextToken().charAt(0);
            text[i] = pattern[i];
        }
        for (int i = 0; i < n-1; i++) {
            text[i+n] = pattern[i];
        }

        int times = kmpCounter(text, pattern);
        int gcd = gcd(times, n);
        
        sb.append(times/gcd).append('/').append(n/gcd);

        System.out.print(sb);
    }
}