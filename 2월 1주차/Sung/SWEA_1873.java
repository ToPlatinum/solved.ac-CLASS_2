package week2_1.SWEA;

import java.util.Scanner;

public class SWEA_1873 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        char[][] map;
        int H, W;
        int orders;
        int T;
        int ur = 0, uc = 0;
        int count = 0;
        char user = '^';
        T = sc.nextInt();
        String recstr;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        String a = "^v<>";
        for (int tc = 0; tc < T; tc++) {
            H = sc.nextInt();
            W = sc.nextInt();
            map = new char[H][W];
            for (int r = 0; r < H; r++) {
                recstr = sc.next();
                for (int c = 0; c < W; c++) {
                    map[r][c] = recstr.charAt(c);
                    if (a.contains(Character.toString(map[r][c]))) {
                        ur = r;
                        uc = c;
                        user = map[r][c];
                        map[r][c] = '.';
                    }
                }
            }
 
            orders = sc.nextInt();
            recstr = sc.next();
            for (int i = 0; i < orders; i++) {
                if (recstr.charAt(i) == 'U') {
                    user = a.charAt(0);
                    if (ur + dr[0] >= 0 && ur + dr[0] < H && uc + dc[0] >= 0 && uc + dc[0] < W
                            && map[ur + dr[0]][uc + dc[0]] == '.') {
                        ur = ur + dr[0];
                        uc = uc + dc[0];
                    }
                } else if (recstr.charAt(i) == 'D') {
                    user = a.charAt(1);
                    if (ur + dr[1] >= 0 && ur + dr[1] < H && uc + dc[1] >= 0 && uc + dc[1] < W
                            && map[ur + dr[1]][uc + dc[1]] == '.') {
                        ur = ur + dr[1];
                        uc = uc + dc[1];
                    }
                } else if (recstr.charAt(i) == 'L') {
                    user = a.charAt(2);
                    if (ur + dr[2] >= 0 && ur + dr[2] < H && uc + dc[2] >= 0 && uc + dc[2] < W
                            && map[ur + dr[2]][uc + dc[2]] == '.') {
                        ur = ur + dr[2];
                        uc = uc + dc[2];
                    }
                } else if (recstr.charAt(i) == 'R') {
                    user = a.charAt(3);
                    if (ur + dr[3] >= 0 && ur + dr[3] < H && uc + dc[3] >= 0 && uc + dc[3] < W
                            && map[ur + dr[3]][uc + dc[3]] == '.') {
                        ur = ur + dr[3];
                        uc = uc + dc[3];
                    }
 
                } else if (recstr.charAt(i) == 'S') {
                    count = 1;
                    while (ur + dr[a.indexOf(user)] * count >= 0 && ur + dr[a.indexOf(user)] * count < H
                            && uc + dc[a.indexOf(user)] * count >= 0 && uc + dc[a.indexOf(user)] * count < W) {
                        if (map[ur + dr[a.indexOf(user)] * count][uc + dc[a.indexOf(user)] * count] == '*') {
                            map[ur + dr[a.indexOf(user)] * count][uc + dc[a.indexOf(user)] * count] = '.';
                            break;
                        }
                        if (map[ur + dr[a.indexOf(user)] * count][uc + dc[a.indexOf(user)] * count] == '#') {
                            break;
                        }
                        count++;
                    }
 
                }
            }
            map[ur][uc] = user;
            System.out.printf("#%d ",tc+1);
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
 
        }
	}

}
