import java.io.*;
import java.util.*;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            arr = input.toCharArray();
            int xCnt = 0;
            int oCnt = 0;

            for (char c : arr) {
                if (c == 'X') xCnt++;
                else if (c == 'O') oCnt++;
            }

            boolean xWin = checkWin('X');
            boolean oWin = checkWin('O');

            boolean isValid = false;

            if (xWin && !oWin && xCnt == oCnt + 1) {
                isValid = true;
            }
            else if (!xWin && oWin && xCnt == oCnt) {
                isValid = true;
            }
            else if (!xWin && !oWin && xCnt == 5 && oCnt == 4) {
                isValid = true;
            }

            if (isValid) sb.append("valid\n");
            else sb.append("invalid\n");
        }

        System.out.print(sb);
    }

    private static boolean checkWin(char p) {
        for (int i = 0; i < 9; i += 3) {
            if (arr[i] == p && arr[i+1] == p && arr[i+2] == p) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i] == p && arr[i+3] == p && arr[i+6] == p) return true;
        }
        if (arr[0] == p && arr[4] == p && arr[8] == p) return true;
        if (arr[2] == p && arr[4] == p && arr[6] == p) return true;

        return false;
    }
}