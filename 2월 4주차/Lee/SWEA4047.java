package February.week4;

import java.io.*;

public class SWEA4047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] sdhc = {'S', 'D', 'H', 'C'};
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            boolean flag = true;
            boolean[][] card = new boolean[90][14];
            String information = br.readLine();
            for (int i = 0; i < information.length(); i += 3) {
                char T = information.charAt(i);
                char X = information.charAt(i + 1);
                char Y = information.charAt(i + 2);
                int cardNum = Integer.parseInt(String.valueOf(X) + String.valueOf(Y));
                if (card[T - '0'][cardNum]) {
                    sb.append("#" + tc + " ERROR\n");
                    flag = false;
                    break;
                }
                card[T - '0'][cardNum] = true;
            }
            if (flag) {
                sb.append("#" + tc + " ");
                for (char pattern : sdhc) {
                    int cnt = -1;
                    for (boolean find : card[pattern - '0']) {
                        if (!find) {
                            cnt++;
                        }
                    }
                    sb.append(cnt + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
