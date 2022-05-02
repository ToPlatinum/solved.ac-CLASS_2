package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20208 {
	static int[] home = new int[2];
	static int[][] map;
	static int[] sel;
	static int N, M, H, currentM, result;
	static ArrayList<Mincho> mincholist = new ArrayList();

	static class Mincho {
		public Mincho(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		int r;
		int c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 민초마을의 크기
		N = Integer.parseInt(st.nextToken());
		// 민우의 초기 체력
		M = Integer.parseInt(st.nextToken());
		// 민트초코 우유를 마실때마다 증가하는 체력의 양
		H = Integer.parseInt(st.nextToken());
		// map 생성
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					home[0] = r;
					home[1] = c;
				} else if (map[r][c] == 2) {
					mincholist.add(new Mincho(r, c));
				}
			}
		}
		// 코드 시작
		sel = new int[mincholist.size()];
		result = 0;
		permutation(0, new boolean[mincholist.size()]);
		System.out.println(result);
	}

	private static int checkgo(int hr, int hc, int dr, int dc) {
		int result = Math.abs(hr - dr) + Math.abs(hc - dc);
		return result;
	}

	private static void permutation(int cnt, boolean[] v) {
		if (cnt == sel.length) {
//			System.out.println(Arrays.toString(sel).replaceAll("[\\]\\,\\[]", ""));
			// 하나 완성했으니 이 순서대로 탐색해본다
			int[] current = new int[] { home[0], home[1] };
			currentM = M;
			int minchocnt = 0;
//			System.out.println("시작hp=" + currentM);
			for (int index = 0; index < sel.length+1; index++) {
				// 마지막까지 다 왔으면 그냥 집까지 갈 수 있는지 체크한 후 결과값 반환
				if(index == sel.length) {
//					System.out.println("마지막 집까지의 시작hp=" + currentM);
//					System.out.println("마지막 집까지의 소요hp=" + checkgo(current[0], current[1], home[0], home[1]));					
					if (checkgo(current[0], current[1], home[0], home[1]) <= currentM) {
						result = Math.max(result, minchocnt);	
//						System.out.println("마지막집까지 갈 수 있음"+result);
					}
					return;
				}
				int[] nextmincho = new int[] { mincholist.get(sel[index]).r, mincholist.get(sel[index]).c };
//				System.out.println(index + "번째 시작hp=" + currentM);
//				System.out.println(Arrays.toString(nextmincho));
				// 그 위치까지 갈수있는지 우선 탐색
//				System.out.println(checkgo(current[0], current[1], nextmincho[0], nextmincho[1]));
				currentM -= checkgo(current[0], current[1], nextmincho[0], nextmincho[1]);
				if (currentM >= 0) {
					// 갈 수 있다면 그 위치에서 집까지도 갈 수 있는지 체크해봄
//					System.out.println("일단 첫위치까지는 갈수있음");
//					System.out.println(index + "번째 현재hp=" + currentM);
					currentM += H;
					if (checkgo(nextmincho[0], nextmincho[1], home[0], home[1]) <= currentM) {
						// 만약에 집까지도 갈 수 있으면
						// minchocnt++를 해준다.
//						System.out.print("집까지도 갈수있음, ");
//						current[0] = nextmincho[0];
//						current[1] = nextmincho[1];
						result = Math.max(result, minchocnt+1);
					}
//					System.out.println("현재 민초카운트=" + minchocnt);
					minchocnt++;
					current[0] = nextmincho[0];
					current[1] = nextmincho[1];
/*					// 갈 수 없다면 이전까지 먹었던 mincho의 개수를 result에 최대값기준으로 갱신해준다
					else {
//					System.out.println("집에 갈수 없어 중단");
						result = Math.max(result, minchocnt - 1);
						checkresult = false;
//						System.out.println(result);
//						return;
					}*/

				}
				// 갈 수 없다면
				else {
//					System.out.println("다음 좌표로 갈수 없어 중단");
//					result = Math.max(result, minchocnt);
//					System.out.println(result);
					return;
				}
			}
			
		}
		// 순열이기때문에 i=이 start가 아니라 0부터여야한다.
		for (int i = 0; i < sel.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[cnt] = i;
				permutation(cnt + 1, v);
				v[i] = false;
			}
		}

	}

}
