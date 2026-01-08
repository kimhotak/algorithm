import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int red = 0;
        int blue = 0;
        for (char c: arr) {
            if (c == 'R') red++;
            else blue++;
        }

        int idx = 0;
        while (idx < n && arr[0] == arr[idx]) idx++;

        int fcnt = 0;
        while (idx < n) {
            if (arr[0] == arr[idx++]) fcnt++;
        }

        int bcnt = 0;
        idx = n-1;
        while (idx >= 0 && arr[n-1] == arr[idx]) idx--;
        while (idx >= 0) {
            if (arr[n-1] == arr[idx--]) bcnt++;
        }

        sb.append(Math.min(Math.min(fcnt, bcnt),Math.min(red,blue)));

        System.out.print(sb);
    }
}