import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int res = 0;
        for (char c: br.readLine().toCharArray()) {
            if (c == 'i' || c == 'j') res++;
        }
        sb.append(res);

        System.out.print(sb);
    }
}