package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 {
	// 뿌요뿌요 맵을 저장할 공간
	static char[][] map;
	static boolean[][] v; // 방문 배열입니다.
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		// 맵 초기화
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int result = Solution();
		System.out.println(result);
	}

	private static int Solution() {

		boolean finish = true; // 게임이 끝났는지 아닌지 저장합니다.(뿌요가 터졌는지 여부)
		int result = 0;
		while (finish) {
			finish = false;
			v = new boolean[12][6];
			// 맵전체를 돌아주면서 터질 뿌요를 찾아줍니다.
			for (int r = 0; r < 12; r++) {
				for (int c = 0; c < 6; c++) {
					if (map[r][c] != '.') {
						// 터질 뿌요가 있다면 finish를 true로 바꿔주겠습니다.
						// bfs결과 true라면 finish를 true로 바꿔주고 false라면 finish값을 그대로 유지합니다.
						finish = bfs(r, c) == true ? true : finish;
						
					}
				}
			}
			// 터진 뿌요가 있다면 맵을 정리해주어야합니다.
			if(finish) {
				organize();
				result++;
			}
		}
		return result;

	}

	private static void organize() {
		Queue<Character> Q = new LinkedList<>();
		
		for(int c=0;c<6;c++) {
			// map의 밑에서부터 빈칸이 아니라면 큐(FIFO)에 담아줍니다
			for(int r = 11;r >= 0 ;r--) {
				if(map[r][c] != '.') {
					
					Q.add(map[r][c]);
					map[r][c] = '.';
				}
			}
			int tempr = 11;
			// 큐가 빌때까지 map의 밑에서 부터 채워나갑니다.
			while(!Q.isEmpty()) {
				map[tempr--][c] = Q.poll();
			}
			
		}
		
		
		
		
	}

	private static boolean bfs(int r, int c) {
		Queue<int[]> Q = new LinkedList<>();
		// 뭉쳐있는 뿌요의 갯수가 4개 이상일 경우에만 뿌요들을 삭제해주어야 하기 때문에 좌표를 저장해야합니다.
		ArrayList<int[]> savepoints = new ArrayList<>();
		// 시작지점에 방문 체크를 해주고, 큐에 처음 위치를 넣어줍니다.
		v[r][c] = true;
		Q.add(new int[] { r, c });
		savepoints.add(new int[] { r, c });
		// 몇개의 뿌요가 뭉쳐있는지 새줄 변수입니다.
		int count = 1;
		// 시작 좌표의 색을 저장해줍니다.
		char color = map[r][c];
		while (!Q.isEmpty()) {
			int[] p = Q.poll();
			// 사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = p[0] + dr[d];
				int nc = p[1] + dc[d];
				// 1. 배열(맵)안에 있어야하고, 2. 방문하지 않았어야 하며, 3. 해당 위치에 있는 뿌요의 색이 시작지점의 색과 같아야합니다.
				if (check(nr, nc) && !v[nr][nc] && map[nr][nc] == color) {
					// 방문 표시
					v[nr][nc] = true;
					// 큐에 넣기
					Q.add(new int[] { nr, nc });
					savepoints.add(new int[] { nr, nc });
					// 카운트값 올려주기
					count++;
				}
			}
		}
		
		// 여기 까지 온다면 이미 주변에 같은 색을 가지고 있는 뿌요를 모두 확인했으며,
		// 그것들의 갯수가 몇개인지와 위치정보가 savepoints배열에 저장되어 있습니다.(위치 정보만 저장해도 size함수를 통해 몇개인지 알 수 있습니다)
		// 4개 이상 뭉쳐있는 경우
		if(count >= 4) {
			for(int i=0;i<savepoints.size();i++) {
				int [] p = savepoints.get(i);
				// 위치 정보를 꺼내서 해당위치에 아무것도 없는 것으로 바꿔줍니다.
				map[p[0]][p[1]] = '.';
			}
			//뿌요가 4개이상 모여 터졌음으로 true를 return해주어야 합니다.
			return true;
		}
		//터지지 않았다면 false를 return합니다.
		return false;
	}

	// 좌표가 배열 밖으로 나갔는지 여부를 확인하는 함수입니다.
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6)
			return true;
		return false;
	}

}
