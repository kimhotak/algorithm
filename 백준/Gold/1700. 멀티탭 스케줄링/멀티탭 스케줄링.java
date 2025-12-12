import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        Deque<Integer>[] ePos = new Deque[k+1];
        for (int i = 1; i <= k; i++) ePos[i] = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int e = Integer.parseInt(st.nextToken());
            arr[i] = e;
            ePos[e].addLast(i);
        }

        int unplugCnt = 0;
        Set<Integer> plugged = new HashSet<>();
        for (int i : arr) {
            ePos[i].pollFirst();

            // 콘센트에 이미 꽃혀있음
            if (plugged.contains(i)) {
                continue;
            }

            // 아직 콘센트가 다 안참
            if (plugged.size() < n) {
                plugged.add(i);
                continue;
            }

            // 꽃혀있는 것들 중에 앞으로 안쓰는거 먼저 뺌
            boolean notUseflag = false;
            for (int p: plugged) {
                if (ePos[p].isEmpty()) {
                    plugged.remove(p);
                    unplugCnt++;
                    plugged.add(i);
                    notUseflag = true;
                    break;
                }
            }
            if (notUseflag) continue;

            // 가장 나중에 쓰이는거 뺌
            int lastest = -1;
            int lastestE = -1;
            for (int p: plugged) {
                if (ePos[p].peekFirst() > lastest) {
                    lastest = ePos[p].peekFirst();
                    lastestE = p;
                }
            }
            plugged.remove(lastestE);
            unplugCnt++;
            plugged.add(i);
        }


        sb.append(unplugCnt);
        System.out.print(sb);
    }
}