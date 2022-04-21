package algostudy;

import java.util.ArrayList;
import java.util.Scanner;

public class 다오의데이트 {
	static int H, W, N;
	static char[][] map;
	static char[][] marid;

	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		map = new char[H][W];
		int[] dao = new int[2];

		for (int i = 0; i < H; i++) {
			String str = sc.next();
			for (int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'D') {
					dao[0] = i;
					dao[1] = j;
				}
			}
		}

		N = sc.nextInt();
		marid = new char[N][2];

		for (int i = 0; i < N; i++) {
			String one = sc.next();
			String two = sc.next();
			marid[i][0] = one.charAt(0);
			marid[i][1] = two.charAt(0);
		}

		date(dao[0], dao[1], 0, new ArrayList<>());
		System.out.println("NO");
	}

	public static void date(int r, int c, int com, ArrayList<Character> load) {
		for (int i = com; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < 2; j++) {
				// 상하좌우
				int dir = WASD(marid[i][j]);
				int nr = r + dx[dir];
				int nc = c + dy[dir];

				if (nr >= 0 && nc >= 0 && nr < H && nc < W && map[nr][nc] != '@') {
					load.add(marid[i][j]);
					flag = true;
					if (map[nr][nc] == 'Z') {
						System.out.println("YES");
						for (int k = 0; k < load.size(); k++) {
							System.out.print(load.get(k));
						}
						System.exit(0);
					} else {
						date(nr, nc, i + 1, load);
						// 젤뒤에꺼 다시 지워조
						load.remove(load.size() - 1);
						flag = false;
					}
				}
			}
			if (!flag)
				return;
		}
	}

	//상하좌우 중에 모냐
	public static int WASD(char dir) {
		int result = -1;
		if (dir == 'W') {
			result = 0;
		} else if (dir == 'A') {
			result = 2;
		} else if (dir == 'S') {
			result = 1;
		} else if (dir == 'D') {
			result = 3;
		}
		return result;
	}

}