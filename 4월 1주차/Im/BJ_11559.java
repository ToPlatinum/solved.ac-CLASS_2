package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11559 {

	static String[] colorList = { "R", "G", "B", "P", "Y" };
	static String[][] map;
	static boolean[][] v;
	static int result;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	// 삭제할 컬러가 여러개일때 한번에 삭제해주기 위한 삭제리스트
	static ArrayList<ArrayList<int[]>> del;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[12][6];
		result = 0;
		String temp = null;
		for (int r = 0; r < 12; r++) {
			temp = br.readLine();
			for (int c = 0; c < 6; c++) {
				map[r][c] = temp.substring(c, c + 1);
			}
		}
//		printmap();
		// 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.
		// 터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.
		// r의 가장 아래부터 위로 순차적으로 이동함
		boolean check = true; //
		while (check) {
			// 매번 방문배열과 del을 초기화해야함
			v = new boolean[12][6];
			del = new ArrayList<ArrayList<int[]>>();
			for (int r = 11; r >= 0; r--) {
				for (int c = 0; c < 6; c++) {
					// 만약 해당 좌표가 컬러라면
					if (!v[r][c] && isColor(map[r][c])) {
						// bfs 수행
						bfs(r, c, map[r][c]);
					}
				}
			}
			if (del.size() > 0) {
				// 삭제 작업 시작
				for (int i = 0; i < del.size(); i++) {
					for (int j = 0; j < del.get(i).size(); j++) {
						int tr = del.get(i).get(j)[0];
						int tc = del.get(i).get(j)[1];
						map[tr][tc] = ".";
					}
				}
				// 삭제 완료 했으니 중력작업 시작
				fallingSlowly();
//				printmap();
			}
			// while을 종료해주기위한 조건
			else if (del.size() == 0) {
				check = false;
			}
			result++;
		}
		System.out.println(result - 1);
	}

	public static void fallingSlowly() {
		// 맨 아랫줄부터 위로 올라가며 확인해줘야 한다.
		Queue<String> col;
		for (int C = 0; C < 6; C++) {
			col = new LinkedList<String>();
			for (int R = 11; R >= 0; R--) {
				if (isColor(map[R][C])) {
					col.add(map[R][C]);
				}
			}
			for (int R = 11; R >= 0; R--) {
				if (col.isEmpty()) {
					map[R][C] = ".";
				} else {
					String color = col.poll();
					map[R][C] = color;
				}
			}
		}
//		printmap();
	}

	public static void bfs(int R, int C, String color) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> tempdel = new ArrayList<>();
		v[R][C] = true;
		q.add(new int[] { R, C });
		tempdel.add(new int[] { R, C });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			// 4방탐색
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isarrout(nr, nc))
					continue;
				if (!v[nr][nc] && map[nr][nc].equals(color)) {
					cnt++;
					v[nr][nc] = true;
					q.add(new int[] { nr, nc });
					tempdel.add(new int[] { nr, nc });
				}
			}

		}
		// 탐색을 다 돌렸으니 cnt가 4 이상인지 확인 후 삭제리스트에 삽입
		if (cnt >= 4) {
			del.add(tempdel);
		}
	}

	public static boolean isarrout(int r, int c) {
		if (r < 0 || c < 0 || r >= 12 || c >= 6)
			return true;
		return false;
	}

	public static boolean isColor(String input) {
		for (int n = 0; n < colorList.length; n++) {
			if (input.equals(colorList[n]))
				return true;
		}
		return false;
	}

	public static void printmap() {
		System.out.println("------------");
		for (String[] a : map) {
			for (String b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}
}
