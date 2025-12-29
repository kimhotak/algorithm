import java.io.*;
import java.util.*;

public class Main {
    static char[] str;

    public static int isPalindrome(int l, int r, int c) {
        if (l >= r) return c;
        if (str[l] == str[r]) {
            return isPalindrome(l+1, r-1, c);
        }
        if (c >= 1) return 2;
        return Math.min(isPalindrome(l+1, r, c+1), isPalindrome(l,r-1,c+1));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            str = br.readLine().toCharArray();
            sb.append(isPalindrome(0, str.length-1, 0)).append('\n');
        }

        System.out.print(sb);
    }
}