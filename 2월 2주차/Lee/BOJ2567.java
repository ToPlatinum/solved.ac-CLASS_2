import java.io.*;
import java.util.StringTokenizer;

public class BOJ2567 {
    static int[][] paper;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        paper = new int[101][101];
        int x, y, cnt;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            fillPaper(x, y);
        }
        cnt = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (paper[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + direction[d][0];
                        int ny = j + direction[d][1];
                        if (paper[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static void fillPaper(int x, int y) {
        for (int i = x; i < x + 10; i++) {
            for (int j = y; j < y + 10; j++) {
                paper[i][j] = 1;
            }
        }
    }

}
