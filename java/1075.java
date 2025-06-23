import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int f = sc.nextInt();
        for (int i = 0; i < 100; i++) {
            if ((n+i) % f == 0) {
                System.out.println((n+i) % 100);
                break;
            }
        }
    }
}