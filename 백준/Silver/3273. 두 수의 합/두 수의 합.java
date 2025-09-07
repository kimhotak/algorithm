import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int x = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n-1 ; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] < x) continue;
                else if (nums[i] + nums[j] == x) res += 1;
                break;
            }
        }
        System.out.print(res);
    }
}