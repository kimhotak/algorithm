import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());
        // 3자리수 4자리수만 고려하자
        // 어차피 2자리 수 까지는 해당하는 수 이다.
        int res = 0;

        if (x < 100) res += x;
        else res += 99;

        for (int i = 100; i <= x; i++) {
            char[] s = Integer.toUnsignedString(i).toCharArray();
            int d = s[1] - s[0];
            boolean isHan = true;
            for (int j = 1; j < s.length - 1; j++) {
                if (s[j+1] - s[j] != d) {
                    isHan = false;
                    break;
                }
            }
            if (isHan) res += 1;
        }

        System.out.println(res);
    }
}