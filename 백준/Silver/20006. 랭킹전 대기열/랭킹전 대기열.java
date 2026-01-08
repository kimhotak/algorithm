import java.io.*;
import java.util.*;

public class Main {
    public static class Player {
        int level;
        String id;
        public Player(int level, String id) {
            this.level = level;
            this.id = id;
        }
    }

    public static class GameRoom {
        int lowLevel, highLevel;
        List<Player> players;
        public GameRoom (Player p1) {
            players = new ArrayList<>();
            lowLevel = p1.level - 10;
            highLevel = p1.level + 10;
            addPlayer(p1);
        }
        public boolean addPlayer (Player p) {
            if (lowLevel > p.level ||
                highLevel < p.level ||
                this.isFull()) return false;
            players.add(p);
            return true;
        }
        public boolean isFull() {
            return players.size() >= m;
        }
        public String print() {
            players.sort(Comparator.comparing(a->a.id));
            StringBuilder sb = new StringBuilder();
            if (this.isFull()) sb.append("Started!");
            else sb.append("Waiting!");
            sb.append('\n');
            for (Player p: players) {
                sb.append(p.level).append(' ');
                sb.append(p.id).append('\n');
            }
            return sb.toString();
        }
    }

    static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<GameRoom> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            Player player = new Player(l,n);
            boolean noRoom = true;
            for (GameRoom room: rooms) {
                if (room.addPlayer(player)) { // 정상등록이면 true
                    noRoom = false;
                    break;
                }
            }
            if (noRoom) rooms.add(new GameRoom(player));
        }

        for (GameRoom room: rooms) sb.append(room.print());

        System.out.print(sb);
    }
}