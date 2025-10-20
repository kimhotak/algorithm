import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] citys = new int[n+1][2]; // 0: 비용, 1: 고객의 수
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                citys[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int i = 0;

        while (dp.get(i++) < c) {
            dp.add(0);
            for (int[] city: citys) {
                if (city[0] > i) continue;
                if (dp.get(i) < dp.get(i - city[0]) + city[1]) {
                    dp.set(i, dp.get(i - city[0]) + city[1]);
                }
            }
        }

        System.out.print(dp.size()-1);
    }
}