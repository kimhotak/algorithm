import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Board b = new Board(arr);
        sb.append(backTrack(b,0));

        System.out.print(sb);
    }

    static int n;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}; // 상하좌우

    public static class Board {
        int[][] board;

        public Board(int[][] arr){
            board = new int[n][];
            for (int i = 0; i < n; i++) {
                board[i] = arr[i].clone();
            }
        }

        public int max() {
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return max;
        }

        public Board clone() {
            Board c = new Board(board);
            return c;
        }

        public void move(int d) {
            for (int i = 0; i < n; i++) {
                if (d == 0) {
                    int idx = 0, len = 0;
                    while (idx < n && len < n) {
                        if (board[idx][i] != 0) {
                            board[len][i] = board[idx][i];
                            if (idx != len) board[idx][i] = 0;
                            len++;
                        }
                        idx++;
                    }
                    idx = 0;
                    while (idx < n-1 && board[idx][i] != 0) {
                        if (board[idx][i] == board[idx+1][i]) {
                            board[idx][i] = board[idx][i] << 1;
                            for (int j = idx + 1; j < n-1; j++) {
                                board[j][i] = board[j+1][i];
                            }
                            board[n-1][i] = 0;
                        }
                        idx++;
                    }
                }

                else if (d == 1) {
                    int idx = n-1, len = n-1;
                    while (idx >= 0 && len >= 0) {
                        if (board[idx][i] != 0) {
                            board[len][i] = board[idx][i];
                            if (idx != len) board[idx][i] = 0;
                            len--;
                        }
                        idx--;
                    }
                    idx = n-1;
                    while (idx > 0 && board[idx][i] != 0) {
                        if (board[idx][i] == board[idx-1][i]) {
                            board[idx][i] = board[idx][i] << 1;
                            for (int j = idx - 1; j > 0; j--) {
                                board[j][i] = board[j-1][i];
                            }
                            board[0][i] = 0;
                        }
                        idx--;
                    }
                }

                else if (d == 2) {
                    int idx = 0, len = 0;
                    while (idx < n && len < n) {
                        if (board[i][idx] != 0) {
                            board[i][len] = board[i][idx];
                            if (idx != len) board[i][idx] = 0;
                            len++;
                        }
                        idx++;
                    }
                    idx = 0;
                    while (idx < n-1 && board[i][idx] != 0) {
                        if (board[i][idx] == board[i][idx+1]) {
                            board[i][idx] = board[i][idx] << 1;
                            for (int j = idx + 1; j < n-1; j++) {
                                board[i][j] = board[i][j+1];
                            }
                            board[i][n-1] = 0;
                        }
                        idx++;
                    }
                }

                else {
                    int idx = n-1, len = n-1;
                    while (idx >= 0 && len >= 0) {
                        if (board[i][idx] != 0) {
                            board[i][len] = board[i][idx];
                            if (idx != len) board[i][idx] = 0;
                            len--;
                        }
                        idx--;
                    }
                    idx = n-1;
                    while (idx > 0 && board[i][idx] != 0) {
                        if (board[i][idx] == board[i][idx-1]) {
                            board[i][idx] = board[i][idx] << 1;
                            for (int j = idx - 1; j > 0; j--) {
                                board[i][j] = board[i][j-1];
                            }
                            board[i][0] = 0;
                        }
                        idx--;
                    }
                }
            }
        }
    }

    public static int backTrack(Board b, int depth) {
        if (depth == 5) {
            return b.max();
        }
        depth++;

        int max = 0;

        Board top = b.clone();
        top.move(0);
        max = Math.max(max, backTrack(top, depth));

        Board bot = b.clone();
        bot.move(1);
        max = Math.max(max, backTrack(bot, depth));

        Board left = b.clone();
        left.move(2);
        max = Math.max(max, backTrack(left, depth));

        b.move(3);
        return Math.max(max, backTrack(b, depth));
    }
}