import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // a의 개수를 구한 뒤에 a의 개수길이 안에 들어있는 b의 개수의 최소
        char[] str = br.readLine().toCharArray();
        int len = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'a') len++;
        }

        int bCnt = 0;
        for (int i = 0; i < len; i++) {
            if (str[i] == 'b') bCnt++;
        }

        int res = bCnt;
        for (int i = 0; i < str.length -1; i++) {
            if (str[(i+len)%str.length] == 'b') bCnt++;
            if (str[i] == 'b') bCnt--;
            res = Math.min(res, bCnt);
        }
        sb.append(res);

        System.out.print(sb);
    }
}