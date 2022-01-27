import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1707 {
    static int[][] arr;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        int num = 1;
        int x, y;
        x = 0;
        y = 0;
        int cnt = 0;
        int d = 0;
        while (cnt != n * n) {
            arr[x][y] = num;
            num++;
            cnt++;
            if (check(x + direction[d][0], y + direction[d][1]) && arr[x + direction[d][0]][y + direction[d][1]] == 0) {
                x += direction[d][0];
                y += direction[d][1];
            } else {
                d = (d + 1) % 4;
                x += direction[d][0];
                y += direction[d][1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean check(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n) {
            return true;
        }
        return false;
    }
}
