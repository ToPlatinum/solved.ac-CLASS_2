package com.ssafy.study.question.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20208 { //진우의 민트초코우유
	static int N,M,H,max;
	static int[][] town;
	static int[] house;
	static ArrayList<Point> mint;
	static boolean[] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //민초마을 크기
		M = Integer.parseInt(st.nextToken()); //진우 초기체력
		H = Integer.parseInt(st.nextToken()); //민초우유 마시면 증가하는 체력의 양
		
		house = new int[2]; //집 좌표
		mint = new ArrayList<>(); //민트초코 좌표
		town = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				town[r][c] = Integer.parseInt(st.nextToken());
				if(town[r][c]==1) {
					//집 위치 저장
					house[0] = r;
					house[1] = c;
				} else if(town[r][c]==2) {
					//민트초코우유 위치 저장
					mint.add(new Point(r,c));
				}
			}
		}
		
		//민트초코우유의 총합은 10개를 넘지 않음
		v = new boolean[mint.size()];
		int sel[] = new int[mint.size()];
		max = 0;
		mintchoco(0,sel);
		
		//진우가 집을 나와서 다시 집으로 돌아올 때 까지 마실 수 있는 민트초코우유의 최대 개수 출력
		System.out.println(max);
	}
	
	private static void mintchoco(int idx, int[] sel) {
		//base part
		if(idx==mint.size()) {
			//우유 순서 다 정했어
			move(sel);
			return;
		}
		
		//inductive part
		for (int i = 0; i < mint.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = i;
				mintchoco(idx+1,sel);
				v[i] = false;
			}
		}
	}
	
	private static void move(int[] sel) {
		//움직일 때마다 hp--
		//hp가 0이 되면 움직일 수 없음
		//2인 곳에 도착하면 H만큼 hp 획득
		int hp = M; 
		int cnt = 0; //민트초코우유 먹은 개수
		
		int r = house[0];
		int c = house[1];
		
		//거리 구하기
		for (int i = 0; i < sel.length; i++) {
			int idx = sel[i]; //해당 번호에 맞는 우유~
			//현재 좌표에서 다음 민초우유까지
			int dist = Math.abs(r-mint.get(idx).r)+Math.abs(c-mint.get(idx).c);
			//집까지 
			int home = Math.abs(house[0]-mint.get(idx).r)+Math.abs(house[1]-mint.get(idx).c);
			
			//체력 다하지 않았으면 다음 민초우유 찾으러 go
			if(hp >= dist) {
				//우유 먹었어
				cnt++; 
				//움직일 때마다 체력 소모되고 민초우유 겟하면 체력 보충돼
				hp = hp - dist + H; 
				 
				if(hp >= home) { //집으로 다시 돌아갈 수 있는 체력 돼
					max = Math.max(max, cnt);
				}
				
				//다음 좌표로 이동
				r = mint.get(idx).r;
				c = mint.get(idx).c;
			}else { //체력 고갈되면 못 움직여
				return;
			}
		}
	}

	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
