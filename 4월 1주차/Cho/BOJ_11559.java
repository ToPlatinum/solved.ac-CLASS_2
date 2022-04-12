package com.ssafy.study.question.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 { //뿌요뿌요
	static class Puyo {
		int r;
		int c;
		
		public Puyo(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static boolean[][] v;
	static final int R=12, C=6; 
	static int Ans;
	static ArrayList<Puyo> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//R 빨강, G 초록, B 파랑, P 보라, Y 노랑
		//같은 색 4개 이상 상하좌우 연결되어 있으면 연결된 뿌요는 한꺼번에 없어짐
		//12행 6열
		map = new char[R][C];
		list = new ArrayList<>();
	
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		//같은 색 4개 이상 상하좌우 연결되어 있으면 연결된 뿌요 붐!
		//같은 색 4개 이상 상하좌우 연결되어 있는지 찾기 
		//찾은 후 뿜 해줘
		//붐하고나서 남은 뿌요 아래로 내려와 
		Ans = 0;
		PuyoPuyo();
		System.out.println(Ans);
		
		//print(map);
	}
	
	private static void PuyoPuyo() {
		
		while(true) {
			boolean flag = true;
			v = new boolean[R][C];
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(!v[r][c] && map[r][c] != '.') {
						bfs(r,c);
					}
					
					//bfs 돌아 list 속 같은 색의 뿌요가 4개 이상이면 붐!
					if(list.size() >= 4) {
						boom();
						flag = false;
					}
					
					//한가지 색의 뿌요 터트린 후 초기화해주기
					list.clear();
				}
			}
			if(flag) break;
			down();
			Ans++;
		}
		
	}

	private static void down() {
		for (int i = 0; i < C; i++) {
			for (int j = R-1; j > 0; j--) {
				if (map[j][i] == '.') {
					for (int k = j - 1; k >= 0; k--) {
						if (map[k][i] != '.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<Puyo> q = new LinkedList<Puyo>();
		list.add(new Puyo(r,c));
		q.add(new Puyo(r,c));
		v[r][c] = true;
		char color = map[r][c]; //해당 칸의 색깔
		
		while(!q.isEmpty()) {
			Puyo p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				//탐색을 시작한 칸의 색깔과 다음 칸들의 색이 같다면 연쇄적인 것
				if(check(nr,nc) && !v[nr][nc] && map[nr][nc] == color) {
					list.add(new Puyo(nr,nc));
					q.add(new Puyo(nr,nc));
					v[nr][nc] = true;
				}
			}
		}
	}

	

	private static void boom() {
		for (int i = 0; i < list.size(); i++) {
			Puyo p = list.get(i);
			map[p.r][p.c] = '.'; //없애주기
		}
	}
	
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) {
			return true;
		}
		return false;
	}

	private static void print(char[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}

}
