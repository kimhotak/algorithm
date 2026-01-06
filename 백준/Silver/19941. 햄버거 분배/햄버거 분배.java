import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int res = 0;
        char[] arr = br.readLine().toCharArray();
        for (int i = 1; i < n; i++) {
            for (int j = Math.max(0,i-k); j < i; j++) {
                if ((arr[i] == 'P' && arr[j] == 'H') ||
                    (arr[i] == 'H' && arr[j] == 'P')) {
                    arr[i] = 'E';
                    arr[j] = 'E';
                    res++;
                    break;
                }
            }
        }
        sb.append(res);

        System.out.print(sb);
    }
}