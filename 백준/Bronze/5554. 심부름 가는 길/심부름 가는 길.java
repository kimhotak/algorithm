import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = 0;
        for (int i = 0; i < 4; i++) {
            t += Integer.parseInt(br.readLine());
        }

        int m = t / 60;
        int s = t % 60;
        sb.append(m).append("\n").append(s);
        
        System.out.print(sb);
    }
}