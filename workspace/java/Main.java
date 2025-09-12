import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> fruit = new ArrayDeque<>();
        ArrayDeque<Integer> count = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (!fruit.isEmpty() && fruit.peekLast() == tmp) {
                count.addLast(count.pollLast()+1);
            }
            else {
                fruit.addLast(tmp);
                count.addLast(1);
            }
        }

        n = fruit.size();
        int res = 0;

        for (int s = 0; s < n; s++) {
            for (int e = 0; e < n; e++) {

            }
        }
    }
}