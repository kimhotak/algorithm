import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int n, m;
    static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};

    static boolean[] tilt(int dir, int[] balls) {
        // dir: 이동할 방향, 0~3, 상하좌우 순
        // balls: 현재 위치를 가지고있고, 이동 한 구슬의 위치를 담을 배열
        // return: {red가 구멍에 빠졌는지, blue가 구멍에에 빠졌는지}
        int[] red = {balls[0],balls[1]};
        int[] blue = {balls[2],balls[3]};

        // red 굴림
        board[blue[0]][blue[1]] = 'B';
        char blockRed = roll(dir, red);
        board[blue[0]][blue[1]] = '.';
        // O일 때, B 일때 처리 필요

        // blue 굴림
        if (blockRed != 'O') board[red[0]][red[1]] = 'R';
        char blockBlue = roll(dir, blue);
        board[red[0]][red[1]] = '.';

        // red가 blue에 의해서 못굴렀을 경우 처리
        if (blockRed == 'B') {
            board[blue[0]][blue[1]] = 'B';
            blockRed = roll(dir, red);
            board[blue[0]][blue[1]] = '.';
        }

        balls[0] = red[0];
        balls[1] = red[1];
        balls[2] = blue[0];
        balls[3] = blue[1];
        return new boolean[]{blockRed == 'O', blockBlue == 'O'};
    }

    static char roll(int dir, int[] ball) {
        // 비어있는 동안 굴리고 ball값 변경
        // return: 앞에 어떤것에 막혔는지
        int y = ball[0], x = ball[1];
        while (board[y + dy[dir]][x + dx[dir]] == '.') {
            y += dy[dir];
            x += dx[dir];
        }
        ball[0] = y;
        ball[1] = x;
        return board[y + dy[dir]][x + dx[dir]];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        int[] balls = new int[4];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();

            for(int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    balls[0] = i;
                    balls[1] = j;
                    board[i][j] = '.';
                }
                else if (board[i][j] == 'B') {
                    balls[2] = i;
                    balls[3] = j;
                    board[i][j] = '.';
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(balls);
        int level = 0;
        boolean isEnd = false;
        while (level < 10 && !isEnd) {
            for (int i = dq.size(); i > 0; i--) {
                int[] cur = dq.pollFirst();
                for(int d = 0; d < 4; d++) {

                    int[] next = cur.clone();
                    boolean[] rbDrop = tilt(d, next);
                    boolean redDrop = rbDrop[0], blueDrop = rbDrop[1];
                    if (redDrop && !blueDrop) {
                        isEnd = true;
                        break;
                    }
                    else if (!redDrop && !blueDrop) {
                        dq.addLast(next);
                    }
                }
            }
            level++;
        }
        System.out.print(isEnd ? 1 : 0);
    }
}