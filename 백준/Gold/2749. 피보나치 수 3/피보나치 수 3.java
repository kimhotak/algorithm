import java.io.*;
import java.util.*;

public class Main {
    static long mod = 1_000_000;
    static HashMap<Long, Long> memo;

    public static Long fibo(Long n) {
        if (memo.containsKey(n)) return memo.get(n);
        long res = 0;
        if ((n&1) == 1) {
            long m = (n+1) / 2 - 1;
            res += fibo(m+1) * fibo(m+1) % mod;
            res += fibo(m) * fibo(m) % mod;
        }
        else {
            long m = n/2;
            res += fibo(m+1) + fibo(m-1);
            res %= mod;
            res *= fibo(m);
        }
        res %= mod;
        memo.put(n,res);
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Long n = Long.parseLong(br.readLine());
        memo = new HashMap<>();
        memo.put(0L,0L);
        memo.put(1L,1L);
        memo.put(2L,1L);


        // Fibonacci = [0, 1, 1, 2, 3, ...]
        // Fn = F_(n-1) + F_(n-2)
        // = 2 * F_(n-2) + F_(n-3)
        // = 3 * F_(n-3) + 2 * F_(n-4)
        // = 5 * F_(n-4) + 3 * F_(n-5)
        // = 8 * F_(n-5) + 5 * F_(n-6)
        // = F_(k) * F_(n-k+1) + F_(k-1) * F_(n-k)

        // n이 짝수일 때 k를 n/2 (= m)로 놓으면 (n = 2m)
        // F_(2m) = F_m * F_(m+1) + F_(m-1) * F_m
        //       = F_m * (F_(m+1) + F_(m-1))

        // n이 홀수일 때 k를 (n-1)/2 (= m)로 놓으면 (n = 2m+1)
        // F_(2m+1) = F_m * F_(m+2) + F_(m-1) * F_(m+1)

        // n이 홀수일 때 k를 (n+1)/2 (= m+1)로 놓으면 (n = 2m+1)
        // F_(2m+1) = F_(m+1) * F_(m+1) + F_m * F_m
        //         = F_(m+1)^2 + F_m^2

        sb.append(fibo(n));

        System.out.print(sb);
    }
}