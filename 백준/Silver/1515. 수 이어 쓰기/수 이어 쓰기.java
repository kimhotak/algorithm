import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] eraseNum = br.readLine().toCharArray();
        int idx = 0;
        int n = 1;
        loop:
        while (true) {
            for (char c: Integer.toString(n).toCharArray()) {
                if (eraseNum[idx] == c) idx++;
                if (idx >= eraseNum.length) break loop;
            }
            n++;
        }
        sb.append(n);

        System.out.print(sb);
    }
}