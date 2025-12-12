import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] str = br.readLine().toCharArray();
        for (char c: str) sb.append(c < 97 ? Character.toLowerCase(c) : Character.toUpperCase(c));
        System.out.print(sb);
    }
}