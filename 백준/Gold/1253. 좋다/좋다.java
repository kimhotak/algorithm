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

        int res = 0;
        for (int i = 0; i < n; i ++) {
            int left = 0;
            int right = n-1;
            while (left < right) {
                if (left == i) { left++; continue; }
                if (right == i) { right--; continue; }

                int sum = nums[left] + nums[right];
                if (sum < nums[i]) left++;
                else if (sum > nums[i]) right--;
                else { res++; break; }

            }
        }

        System.out.print(res);
    }
}