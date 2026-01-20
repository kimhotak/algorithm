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

    public static List<Integer> kmp(char[] text, char[] pattern, int[] lps) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
                if (j == pattern.length) {
                    res.add(i - pattern.length);
                    j = lps[j-1];
                }
            }
            else if (j != 0) j = lps[j-1];
            else i++;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        char[] text = str.toCharArray();
        char[] pre = br.readLine().toCharArray();
        char[] suf = br.readLine().toCharArray();

        List<Integer> p = kmp(text, pre, getLps(pre));
        List<Integer> f = kmp(text, suf, getLps(suf));

        Set<String> res = new HashSet<>();

        for (int i = 0; i < p.size(); i++) {
            for (int j = 0; j < f.size(); j++) {
                if (p.get(i) > f.get(j) ||
                    p.get(i) + pre.length > f.get(j) + suf.length) continue;
                res.add(str.substring(p.get(i),f.get(j)));
            }
        }

        sb.append(res.size());

        System.out.print(sb);
    }
}