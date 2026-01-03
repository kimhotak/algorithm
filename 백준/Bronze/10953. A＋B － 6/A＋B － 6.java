import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] str = br.readLine().split(",");
            sb.append(Integer.parseInt(str[0]) + Integer.parseInt(str[1]));
            sb.append('\n');
        }

        System.out.print(sb);
    }
}