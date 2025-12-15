import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Integer>[] partyMember = new List[m+1];
        for (int i = 0; i <= m; i++) partyMember[i] = new ArrayList<>();
        List<Integer>[] joinParty = new List[n+1];
        for (int i = 0; i <= n; i++) joinParty[i] = new ArrayList<>();
        
        for (int i = 0; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int member = Integer.parseInt(st.nextToken());
                partyMember[i].add(member);
                joinParty[member].add(i);
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] knowedParty = new boolean[m+1];
        dq.addLast(0);
        knowedParty[0] = true;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            for (int member: partyMember[cur]) {
                for (int next: joinParty[member]) {
                    if (knowedParty[next]) continue;
                    dq.addLast(next);
                    knowedParty[next] = true;
                }
            }
        }

        int cnt = 0;
        for (boolean p: knowedParty) if(!p)cnt++;
        sb.append(cnt);

        System.out.print(sb);
    }
}