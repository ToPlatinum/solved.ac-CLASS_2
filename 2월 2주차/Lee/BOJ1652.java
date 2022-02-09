import java.io.*;

public class BOJ1652 {
    static int[][] direction = {{0, 1}, {1, 0}};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt;
        int width, length;
        width = 0;
        length = 0;
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    for (int d = 0; d < 2; d++) {
                        int nx = i + direction[d][0];
                        int ny = j + direction[d][1];
                        cnt = 1;
                        while (check(nx, ny) && map[nx][ny] == '.') {
                            cnt++;
                            nx = nx + direction[d][0];
                            ny = ny + direction[d][1];
                        }
                        int prevX = i - direction[d][0];
                        int prevY = j - direction[d][1];
                        if (cnt >= 2 && (!check(prevX, prevY) || map[prevX][prevY] != map[i][j])) {
                            if (d == 0) {
                                width++;
                            } else {
                                length++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(width + " " + length);
    }

    private static boolean check(int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            return true;
        }
        return false;
    }
}
