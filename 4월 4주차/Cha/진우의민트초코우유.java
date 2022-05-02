package algostudy;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 20220502
 * 백준 : 20208 진우의민트초코우유
 */
public class 진우의민트초코우유 {
	static int[][] map;
	static boolean[] v;
	static int N, M, H, MinchoCnt, Ans;
	static ArrayList<int[]> mincho;
	static int homeR, homeC;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//마을의 크기
		map = new int[N][N];
		M = sc.nextInt();//초기체력
		H = sc.nextInt();//민초체력

		
		mincho = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				//집좌표 저장
				if (map[i][j] == 1) {
					homeR = i;
					homeC = j;
				} 
				//민초갯수, 위치 저장
				else if (map[i][j] == 2) {
					MinchoCnt++;
					mincho.add(new int[] { i, j });
				}
			}
		}
		
		v = new boolean[MinchoCnt];


		DFS(homeR, homeC, M, 0);
		
		System.out.println(Ans);

	}

	private static void DFS(int r, int c, int hp, int cnt) {
		int dist = Math.abs(r-homeR)+Math.abs(c-homeC);
		if(dist<=hp) {
			Ans = Math.max(Ans, cnt);
		}
		for (int i = 0; i < MinchoCnt; i++) {
			dist = Math.abs(r - mincho.get(i)[0]) + Math.abs(c - mincho.get(i)[1]);
			if(!v[i] && dist <= hp) {
				v[i] = true;
				DFS(mincho.get(i)[0], mincho.get(i)[1], hp - dist + H, cnt + 1);
				v[i] = false;
			}
		}
	}

}
