import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // counter
        List<Integer>[] alpha = new List[26];
        for (int i = 0; i < 26; i++) alpha[i] = new ArrayList<>();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            for (int i = 0; i < 26; i++) alpha[i].clear();

            char[] str = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < str.length; i++) {
                alpha[str[i]-'a'].add(i);
            }

            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (alpha[i].size() < k) continue;
                for (int j = 0; j + k - 1 < alpha[i].size(); j++) {
                    int len = alpha[i].get(j+k-1) - alpha[i].get(j) +1;
                    max = Math.max(max, len);
                    min = Math.min(min, len);
                }
            }

            if (max == Integer.MIN_VALUE) sb.append(-1);
            else sb.append(min).append(' ').append(max);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}