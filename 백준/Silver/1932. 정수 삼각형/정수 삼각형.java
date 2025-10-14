import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] tri = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                tri[i][j] += Math.max(tri[i+1][j], tri[i+1][j+1]);
            }
        }

        System.out.print(tri[0][0]);
    }
}