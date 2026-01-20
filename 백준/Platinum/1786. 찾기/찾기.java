import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] text = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();

        int[] lps = new int[pattern.length];
        int i = 1, j = 0;
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) {
                lps[i++] = ++j;
            }
            else {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    lps[i++] = 0;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        i = 0;
        j = 0;
        while (i < text.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
                if (j == pattern.length) {
                    res.add(i + 1 - pattern.length);
                    j = lps[j-1];
                }
            }
            else {
                if (j != 0) {
                    j = lps[j-1];
                }
                else i++;
            }
        }

        sb.append(res.size()).append('\n');
        for (int r: res) sb.append(r).append(' ');


        System.out.print(sb);
    }
}