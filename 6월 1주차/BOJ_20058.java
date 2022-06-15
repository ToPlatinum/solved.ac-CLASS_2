package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20058 {
	static int N, Q;
	static int map[][];
	static int L[];
	static int mapsize;
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, -1, 0, 1 };
	static int sum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		mapsize = (int) Math.pow(2, N);
		map = new int[mapsize][mapsize];
		sum = 0;
		L = new int[Q];
		for (int i = 0; i < mapsize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapsize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
		firestorm();
//		
//		for(int r=0;r<mapsize;r++) {
//			for(int c=0;c<mapsize;c++) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
		int biggest = biggestland();
		System.out.println(sum);
		System.out.println(biggest);
	}

	private static int biggestland() {
		boolean v[][];
		v = new boolean[mapsize][mapsize];
		int biggest = 0;

		for (int r = 0; r < mapsize; r++) {
			for (int c = 0; c < mapsize; c++) {
				if (!v[r][c] && map[r][c] != 0) {
					Queue<int[]> Q = new LinkedList<>();
					int size = 1;
					v[r][c] = true;
					Q.add(new int[] { r, c });
					while (!Q.isEmpty()) {
						int[] q = Q.poll();
						for (int d = 0; d < 4; d++) {
							int nr = q[0] + dr[d];
							int nc = q[1] + dc[d];
							if( check(nr,nc)&& !v[nr][nc] && map[nr][nc]!=0) {
								v[nr][nc] = true;
								Q.add(new int[] {nr,nc});
								size++;
							}
						}
					}
					if(size > biggest) {
						biggest = size;
					}
				}
			}
		}
		return biggest;
	}

	private static void firestorm() {

		for (int i = 0; i < Q; i++) {
			int l = L[i];
			int rotatesize = (int) Math.pow(2, l);
			int rotatecount = mapsize / rotatesize;
			int tempmap[][] = new int[mapsize][mapsize];
			// 돌리기
			for (int rotr = 0; rotr < rotatecount; rotr++) {
				for (int rotc = 0; rotc < rotatecount; rotc++) {
					for (int r = 0; r < rotatesize; r++) {
						for (int c = 0; c < rotatesize; c++) {
							int nr = rotatesize * rotr + r;
							int nc = rotatesize * rotc + c;
							tempmap[nr][nc] = map[rotatesize * (rotr + 1) - c - 1][rotatesize * rotc + r];
						}
					}
				}
			}
			boolean check[][] = new boolean [mapsize][mapsize];
			// 얼음 녹이기
			for (int r = 0; r < mapsize; r++) {
				for (int c = 0; c < mapsize; c++) {
					if(tempmap[r][c]!=0) {
						int count = 0;
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if (check(nr, nc) && tempmap[nr][nc] != 0) {
								count++;
							}
						}
						if (count < 3) {
							check[r][c] = true;
							sum--;
						}
					}
					
				}
			}
			for(int r=0;r<mapsize;r++) {
				for(int c=0;c<mapsize;c++) {
					if(check[r][c]) {
						tempmap[r][c]--;
					}
				}
			}
			map = tempmap;
			
//			for(int r=0;r<mapsize;r++) {
//				for(int c=0;c<mapsize;c++) {
//					System.out.print(map[r][c] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < mapsize && nc >= 0 && nc < mapsize)
			return true;
		return false;
	}

}
