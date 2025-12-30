import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        BigInteger t;
        for (int i = 1; i < n; i++) {
            t = a.add(b);
            a = b;
            b = t;
        }
        
        sb.append(n==0 ? a: b);

        System.out.print(sb);
    }
}