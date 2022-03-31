package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_18428 {
	static int N;
	static String[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<int[]> Tmap;
	static boolean check;
	static int resultcount = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		v = new boolean[N][N];
		Tmap = new ArrayList();
		int cnt = 0;
		for (int r = 0; r < map.length; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < map.length; c++) {
				map[r][c] = st.nextToken();
				if (map[r][c].equals("T")) {
					Tmap.add(new int[] { r, c });
				}
			}
		}
		dfs(0, 0, 0);
		if (resultcount > 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");

		}
//		정확히 3개의 장애물을 설치하여 모든 학생들을 감시로부터 피하도록 할 수 있는지의 여부
	}

	public static boolean findS() {
		int Tcnt = Tmap.size();
		for (int n = 0; n < Tcnt; n++) {
			// 4방탐색 시작
			for (int d = 0; d < dc.length; d++) {
				// 선생님들의 좌표 뽑기
				int tr = Tmap.get(n)[0];
				int tc = Tmap.get(n)[1];
				while (true) {
					tr = tr + dr[d];
					tc = tc + dc[d];

					// 맵 범위를 벗어난다면 break;
					if (tr < 0 || tr >= N || tc < 0 || tc >= N) {
						break;
					}
					// 장애물 만나면 break;
					if (map[tr][tc].equals("O")) {
						break;
					}
					// 선생님들이 학생을 발견해서 false 출력
					if (map[tr][tc].equals("S")) {
						return false;
					}
				}
			}

		}
		// 선생님들이 학생을 발견 못해서 true
		return true;
	}

	private static void dfs(int i, int j, int cnt) {
		// 장애물이 3개가 되면 감시 시작
		if (cnt == 3) {
//			System.out.println(count++);
			boolean result = findS();
			if (result) { // 만약 학생들을 발견 못했다면
//				print();
//				System.out.println(result);
				resultcount++;
			}
			return;
		}
		for (int r = i; r < N; r++) {
			for (int c = j; c < N; c++) {
				if (!v[r][c] && map[r][c].equals("X")) {
					map[r][c] = "O";
					v[r][c] = true;
					dfs(i, j + 1, cnt + 1);
					map[r][c] = "X";
					v[r][c] = false;
				}
			}
		}

	}

	private static void print() {
		System.out.println();
		for (String[] a : map) {
			for (String b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}

	}

}
