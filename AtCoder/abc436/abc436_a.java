import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        sb.append("o".repeat(n-s.length())).append(s);


        System.out.print(sb);
    }
}