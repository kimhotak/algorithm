import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] height = new int[1001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            height[l] = h;
        }

        int left = 1;
        int right = 1000;
        while (left < right) {
            if (height[left] <= height[right]) {
                height[left+1] = Math.max(height[left+1], height[left]);
                left++;
            }
            else{
                height[right-1] = Math.max(height[right-1], height[right]);
                right--;
            }
        }

        System.out.print(Arrays.stream(height).sum());
    }
}