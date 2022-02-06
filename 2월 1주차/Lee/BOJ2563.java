import java.util.*;

public class BOJ2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x, y, result;
        result = 0;
        int[][] map = new int[100][100];
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            for (int px = x; px < x + 10; px++) {
                for (int py = y; py < y + 10; py++) {
                    map[px][py] = 1;
                }
            }
        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

}
