package com.ssafy.study.question.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18188 { //다오의 데이트

	static int H,W,N;
	static char[][] map;
	static char[][] marid;
	static ArrayList<Character> list;
	static String result;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력받기
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		
		//'.'인 경우, 아무것도 없음
		//'D'인 경우, 다오가 있음
		//'Z'인 경우, 디지니가 있음
		//'@'인 경우, 블록이 있음
		int daoR = 0, daoC = 0;
		
		for (int r = 0; r < H; r++) {
			String s = br.readLine();
			for (int c = 0; c < W; c++) {
				map[r][c] = s.charAt(c);
				
				if(map[r][c]=='D') {//다오 위치(시작)
					daoR = r;
					daoC = c;
				}
			}
		}
		
		N = Integer.parseInt(br.readLine()); //다오가 움직일 수 있는 최대 횟수
		
		//마리드의 방해
		marid = new char[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			marid[i][0] = st.nextToken().charAt(0);
			marid[i][1] = st.nextToken().charAt(0);
		}

		//만약 어떤 선택을 하더라도 다오가 디지니를 만날 수 없다면, 첫 번째 줄에 "NO"를 출력한다.
		//만약 다오가 디지니를 만날 수 있다면, 첫 번째 줄에 "YES"를 출력한다. 또한 두번째 줄에 다오가 어떻게 움직여야 하는지를 출력한다.
		//다오가 디지니를 만날 수 있는 방법이 여러 가지라면, 그 중 아무거나 출력해도 정답으로 인정된다.
		result = "NO";
		bfs(daoR,daoC);
		
		if(result != "YES") System.out.println(result);
	}
	
	private static void bfs(int daoR, int daoC) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(daoR,daoC,"")); //현재좌표,이동하지 않았기 때문에 경로는 x
		
		int cnt = 0;
		while(!q.isEmpty()) {
			//같은 cnt에 다오가 움직이는 것을 보아야 하기 때문에 
			//q에 들어간 사이즈만큼 돌린 후 cnt를 ++ 해줘야 함
			int size = q.size();
			while(size-- > 0) {
				Point p = q.poll();
				
				//다오의 최대 움직임 횟수
				if(cnt>=N) return;
				
				//마리드의 방해로 2 방향
				for (int i = 0; i < 2; i++) {
					
					//방향 구해서 탐색
					int d = WASD(marid[cnt][i]);
					int nr = p.r+dr[d];
					int nc = p.c+dc[d];
					
					//범위 체크하고 벽이 아니라면 이동가능
					if(check(nr,nc) && map[nr][nc] != '@') {
						
						//다음 칸이 디지니라면 이동방향 넣어주고 리턴
						if(map[nr][nc] == 'Z') {
							result = "YES";
							System.out.println(result);
							System.out.println(p.path+marid[cnt][i]);
							return;
						}
						
						//이동가능한 방향 넣어주기
						q.add(new Point(nr, nc,p.path+marid[cnt][i]));
					}
				}
			}
			cnt++;
		}
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<H && nc>=0 && nc<W) {
			return true;
		}
		return false;
	}
	
	private static int WASD(char dir) {
		int d = 0;
		
		//상하좌우
		//0123
		switch (dir) {
		case 'W': //상
			d = 0;
			break;
		case 'A': //좌
			d = 2;
			break;
		case 'S': //하
			d = 1;
			break;
		case 'D'://우
			d = 3;
			break;
		}
		
		return d;
	}

	static class Point {
		int r;
		int c;
		String path;
		
		public Point(int r, int c, String path) {
			super();
			this.r = r;
			this.c = c;
			this.path = path;
		}
	}
}
