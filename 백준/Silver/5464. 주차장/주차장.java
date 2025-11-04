import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] chargePerWeight = new int[n];
        for (int i = 0; i < n; i++) {
            chargePerWeight[i] = Integer.parseInt(br.readLine());
        }

        int[] carWeight = new int[m+1];
        for (int i = 1; i <= m; i++) {
            carWeight[i] = Integer.parseInt(br.readLine());
        }

        int income = 0;
        int[] place = new int[n];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < 2 * m; i++) {
            int carIndex = Integer.parseInt(br.readLine());
            if (carIndex > 0) {
                q.addLast(carIndex);
                int idx = 0;
                while (idx < n && place[idx] != 0) idx++;
                if (idx < n && place[idx] == 0) {
                    place[idx] = q.pollFirst();
                }
            }
            else {
                carIndex = -carIndex;
                for (int j = 0; j < n; j++) {
                    if (place[j] == carIndex){
                        income += chargePerWeight[j] * carWeight[carIndex];
                        place[j] = 0;
                        if (!q.isEmpty()) {
                            place[j] = q.pollFirst();
                        }
                        break;
                    }
                }
            }
        }

        System.out.print(income);
    }
}