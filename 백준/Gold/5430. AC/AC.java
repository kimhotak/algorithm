import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (0 < t--) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] tmp = br.readLine().split("[,\\[\\]]");
            ArrayDeque<Integer> dq = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {
                dq.addLast(Integer.parseInt(tmp[i]));
            }

            boolean isReverse = false;
            boolean isError = false;
            for (char op : p.toCharArray()) {
                if (op == 'R') isReverse = !isReverse;
                else if (dq.isEmpty()) {
                    isError = true;
                    break;
                }
                else if (isReverse) dq.pollLast();
                else dq.pollFirst();
            }

            if (isError) sb.append("error\n");
            else {
                if (isReverse) {
                    List<Integer> rev = new ArrayList<Integer>();
                    while (!dq.isEmpty()) {
                        rev.add(dq.pollLast());
                    }
                    sb.append(rev.toString().replace(" ", "")).append('\n');
                }
                else sb.append(dq.toString().replace(" ", "")).append('\n');
            }
        }
        System.out.print(sb);
    }
}