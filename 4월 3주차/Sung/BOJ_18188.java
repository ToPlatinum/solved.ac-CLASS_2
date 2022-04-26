package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18188 {
	static int H, W;
	static char map[][];
	// 마리드의 명령을 저장합니다.
	static char order[][];
	// 명령에 따라 방향을 정해줍니다.
	static Map<Character, Integer> mapper = new HashMap<>();
	// 방향에 따라 행,렬로 얼마나 움직여야하는지 저장한 배열입니다.
	// 상 좌 하 우
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	// 다오의 위치
	static int dao[] = new int[2];
	// 디즈니의 위치
	static int diz[] = new int[2];
	static int orderl;
	static String answer;
	static ArrayList<Character> history;
	
	
	static class Point{
		int r,c;
		ArrayList<Character> his;
		public Point(int r, int c, ArrayList<Character> his) {
			super();
			this.r = r;
			this.c = c;
			this.his = his;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		answer = "NO";
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		for (int r = 0; r < H; r++) {
			str = br.readLine();
			for (int c = 0; c < W; c++) {
				map[r][c] = str.charAt(c);
				// 다오의 위치를 저장합니다.
				if(map[r][c] == 'D') {
					dao[0] = r;
					dao[1] = c;
					map[r][c] = '.';
				}
				// 디즈니의 위치를 저장합니다.
				if(map[r][c] == 'Z') {
					diz[0] = r;
					diz[1] = c;
					map[r][c] = '.';
				}
			}
		}
		// 움직일 수 있는 횟수를 저장합니다.
		orderl = Integer.parseInt(br.readLine());
		order = new char[orderl][2];
		for(int i=0;i<orderl;i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = st.nextToken().charAt(0);
			order[i][1] = st.nextToken().charAt(0);
		}
		// mapper에 세팅을 해줍니다.
		// W명령이면 dr,dc(방향에 따라 행,렬로 얼마나 움직여야하는지 저장한 배열)
		// 의 0번 인덱스 값을 가져올 것입니다.
		mapper.put('W', 0);
		mapper.put('A', 1);
		mapper.put('S', 2);
		mapper.put('D', 3);
		bfs();
		System.out.println(answer);
		if(answer.equals("YES")) {
			for(int i=0;i<history.size();i++) {
				System.out.print(history.get(i));
			}
		}
		
		
	}

	private static void bfs() {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(dao[0],dao[1],new ArrayList<>()));
		// 이동한 횟수를 저장합니다.
		int level=0;
		while(!Q.isEmpty()) {
			int size = Q.size();
			// 이동한 횟수를 세기 위해 Q의 size만큼 poll을 하고 이후에 level하나를 올려줍니다.
			for(int s=0;s<size;s++) {
				Point p = Q.poll();
				
				for(int d=0;d<2;d++) {
					// 방향을 구합니다.
					int dir = mapper.get(order[level][d]);
					int nr = p.r + dr[dir];
					int nc = p.c + dc[dir];
					if(check(nr,nc) && map[nr][nc] == '.') {
						
						ArrayList<Character> narr = new ArrayList<>();
						for(int i=0;i<p.his.size();i++) {
							narr.add(p.his.get(i));
						}
						if(diz[0] == nr && diz[1] == nc) {
							answer = "YES";
							history = narr;
						}
						narr.add(order[level][d]);
						Q.add(new Point (nr,nc,narr));
					}
				}
			}
			level++;
			if(level >= orderl) {
				return;
			}
		}

	}
	// 새로운 좌표가 맵을 빠져나갔는지 판단합니다.
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<H && nc>=0 && nc <W)return true;
		return false;
	}

}
