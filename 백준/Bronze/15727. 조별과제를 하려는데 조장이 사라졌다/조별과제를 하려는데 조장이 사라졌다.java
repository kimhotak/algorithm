import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int l = Integer.parseInt(br.readLine());
        sb.append((l-1) / 5 + 1);

        System.out.print(sb);
    }
}