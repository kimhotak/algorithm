import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static StringBuilder sb;

    public static boolean dfs(int p) {
        while (p < 9*9 && board[p/9][p%9] != 0) p++;
        if (p >= 9*9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append('\n');
            }
            return true;
        }

        int y = p/9, x = p%9;
        boolean[] able = new boolean[10];
        for (int i = 0; i < 9; i++) {
            able[board[y][i]] = true;
            able[board[i][x]] = true;
            able[board[y/3*3 + i/3][x/3*3 + i%3]] = true;
        }

        for (int i = 1; i <= 9; i++) {
            if (able[i]) continue;
            board[y][x] = i;
            if (dfs(p+1)){
                return true;
            }
            board[y][x] = 0;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                board[i][j] = tmp[j] - '0';
            }
        }

        dfs(0);


        System.out.print(sb);
    }
}