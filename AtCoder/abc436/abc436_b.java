import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        int r = 0, c = (n-1)/2, k = 1;
        grid[r][c] = k++;
        for (int i = n*n-1; i > 0; i--) {
            if (grid[(r + n - 1)%n][(c+1)%n] == 0) {
                r = (r + n - 1) % n;
                c = (c + 1) % n;
            }
            else r = (r + 1) % n;
            grid[r][c] = k++;
        }


        for (int[] g: grid) {
            for (int i : g) sb.append(i).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}