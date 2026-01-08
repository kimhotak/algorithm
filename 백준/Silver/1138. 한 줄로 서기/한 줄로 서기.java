import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] res = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            res[i] = i+1;
        }
        
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < arr[i]; j++) {
                int tmp = res[i+j];
                res[i+j] = res[i+j+1];
                res[i+j+1] = tmp;
            }
        }
        
        for (int r: res) sb.append(r).append(' ');

        System.out.print(sb);
    }
}