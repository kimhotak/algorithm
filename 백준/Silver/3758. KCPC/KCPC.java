import java.io.*;
import java.util.*;

public class Main {
    public static class Team implements Comparable<Team>{
        int id;
        int[] scores = new int[k+1];
        int scoreSum = 0;
        int reqCnt = 0;
        int lastReq = -1;

        public Team(int id) {
            this.id = id;
        }

        public void addLog(int qNum, int score, int reqTime) {
            reqCnt++;
            lastReq = reqTime;
            if (scores[qNum] < score) {
                scoreSum += score - scores[qNum];
                scores[qNum] = score;
            }
        }

        @Override
        public int compareTo(Team other) {
            if (this.scoreSum != other.scoreSum) return other.scoreSum - this.scoreSum;
            if (this.reqCnt != other.reqCnt) return this.reqCnt - other.reqCnt;
            return this.lastReq - other.lastReq;
        }
    }

    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n+1];
            for (int i = 0; i <= n; i++) {
                teams[i] = new Team(i);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                teams[id].addLog(j,s,i);
            }

            Team myTeam = teams[t];
            int betterTeam = 0;
            for (Team team: teams) {
                if (myTeam.compareTo(team) > 0) betterTeam++;
            }

            sb.append(betterTeam+1).append('\n');
        }

        System.out.print(sb);
    }
}