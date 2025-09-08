import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] meeting = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) meeting[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });

        int res = 0;
        int bfrEnd = 0;
        for (int i = 0; i < n; i++) {
            if (meeting[i][0] >= bfrEnd) { // 회의 시작 O
                bfrEnd = meeting[i][1];
                res += 1;
            }
            else if (meeting[i][1] < bfrEnd){ // 회의 시작 X, 뒷회의 하는게 이득
                bfrEnd = meeting[i][1];
            }
        }
        System.out.print(res);
    }
}