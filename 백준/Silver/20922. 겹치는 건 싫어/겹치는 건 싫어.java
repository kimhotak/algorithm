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

        int[] arr = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int[] count = new int[max+1];
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            count[arr[right]]++;
            while (count[arr[right]] > k) {
                count[arr[left++]]--;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        sb.append(maxLen);

        System.out.print(sb);
    }
}