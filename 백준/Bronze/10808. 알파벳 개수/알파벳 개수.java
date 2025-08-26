import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alpabet = new int[26];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            alpabet[(int) s.charAt(i) - 97]++;
        }
        for (int a : alpabet) {
            sb.append(a).append(' ');
        }
        System.out.print(sb);
    }
}