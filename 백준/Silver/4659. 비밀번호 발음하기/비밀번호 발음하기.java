import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String pw;
        boolean[] isaeiou = new boolean[26];
        for (char c: "aeiou".toCharArray()) {
            isaeiou[c-'a'] = true;
        }

        while (true) {
            pw = br.readLine();
            if (pw.equals("end")) break;

            sb.append("<").append(pw).append("> is ");
            boolean e1 = true, e2 = false, e3 = false;

            for (int i = 0; i < pw.length(); i++) {
                if (isaeiou[pw.charAt(i)-'a']) e1 = false;

                if (i > 1 && isaeiou[pw.charAt(i-1)-'a'] == isaeiou[pw.charAt(i)-'a']
                    && isaeiou[pw.charAt(i-2)-'a'] == isaeiou[pw.charAt(i)-'a']) e2 = true;

                if (i != 0 && pw.charAt(i) != 'e' && pw.charAt(i) != 'o' &&
                    pw.charAt(i) == pw.charAt(i-1)) e3 = true;
            }

            if (e1 || e2 || e3) sb.append("not ");
            sb.append("acceptable.\n");
        }

        System.out.print(sb);
    }
}