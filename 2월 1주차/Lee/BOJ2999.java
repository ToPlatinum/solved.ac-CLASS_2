import java.io.*;

public class BOJ2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        int row = 1;
        int col = msg.length();
        while (row <= col) {
            if (msg.length() % row == 0 && row <= msg.length() / row) {
                col = msg.length() / row;
            }
            row++;
        }
        row = msg.length() / col;
        char[][] word = new char[row][col];
        for (int idx = 0; idx < msg.length(); idx++) {
            Point:
            {
                for (int j = 0; j < col; j++) {
                    for (int i = 0; i < row; i++) {
                        if (word[i][j] == '\u0000') {
                            word[i][j] = msg.charAt(idx);
                            break Point;
                        }
                    }
                }
            }
        }
        String result = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result += word[i][j];
            }
        }
        System.out.println(result);
    }
}
