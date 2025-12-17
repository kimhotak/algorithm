import java.io.*;
import java.util.*;

public class Main {
    static int a, b, c;
    public static long divide(long ex) {
        if (ex == 1) return a%c;
        long temp = divide(ex/2);
        if (ex%2==1) return (temp * temp % c) * a % c;
        return temp * temp % c;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a %= c;

        // (a * b) % c == ((a % c) * (b % c)) % c
        // true
        
        sb.append(divide(b));
        System.out.print(sb);
    }
}