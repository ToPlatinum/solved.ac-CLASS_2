package edu.ssafy.day0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836 { //공주님을 구해라 !
	static int N,M,T;
	static int Ans=0;
	static int[][] map;
	static boolean[][][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); //제한 시간
		
		map = new int[N][M];
		v = new boolean[N][M][2]; //그람 여부- 0:x, 1:o
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		if(bfs(0,0)) {
			System.out.println(Ans);
		}else {
			System.out.println("Fail");
		}
		
		//print(map);
	}
	
	private static boolean bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		v[r][c][0] = true;
		q.add(new Point(r,c,0,false));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			//제한시간  넘으면  x
			if(p.time > T) break;
			
			//공주 구했다
			if(p.r == N-1 && p.c == M-1) {
				Ans = p.time;
				return true;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if(check(nr,nc)) {
					if(!p.gram) { //그람 없다
						if(!v[nr][nc][0] && map[nr][nc]!=1) {
							if(map[nr][nc]==0) { //
								v[nr][nc][0] = true;
								q.add(new Point(nr, nc, p.time+1, p.gram));
							} else { //그람 get
								v[nr][nc][1] = true;
								q.add(new Point(nr, nc, p.time+1, true));
							}
						}
					} else { //get - 그람이 부술 수 있는 벽의 개수는 제한 없음
						if(!v[nr][nc][1]) {
							v[nr][nc][1] = true;
							q.add(new Point(nr, nc, p.time+1, p.gram));
						}
					}
				}
			}

		}
		
		return false;
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<M) {
			return true;
		}
		return false;
	}

	static class Point {
		int r;
		int c;
		int time;
		boolean gram;
		
		public Point(int r, int c, int time, boolean gram) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.gram = gram;
		}
	}

	private static void print(int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}
}
