import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int buger = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            buger = Math.min(buger,Integer.parseInt(br.readLine()));
        }
        int drink = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            drink = Math.min(drink,Integer.parseInt(br.readLine()));
        }
        sb.append(buger + drink - 50);
        
        System.out.print(sb);
    }
}