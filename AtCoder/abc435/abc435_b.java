import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int l = 0; l < n; l++) {
            for (int len = 1; l+len < n; len++) {
                int sum = 0;
                for (int i = l; i <= l+len; i++) {
                    sum += arr[i];
                }
                cnt++;
                for (int i = l; i <= l+len; i++) {
                    if (sum % arr[i] == 0){
                        cnt--;
                        break;
                    }
                }
            }
        }

        sb.append(cnt);
        System.out.print(sb);
    }
}