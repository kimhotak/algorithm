import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 9; i++) {
            n -= Integer.parseInt(br.readLine());
        }

        sb.append(n);
        
        System.out.print(sb);
    }
}