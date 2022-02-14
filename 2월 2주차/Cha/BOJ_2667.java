package m2week2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2667 {
	static int map[][];// 지도
	static boolean visit[][]; // 방문 체크
	static int N; // 지도 크기
	static int count = 1; // 단지 수

	// 상 하 좌 우 사방탐색 델타선언
	static int dc[] = { -1, 1, 0, 0 };
	static int dr[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];// 지도 맨들기
		visit = new boolean[N][N];// 방문확인 배열 맨들기

		// 입력처리--------------------------------------------------------------------
		for (int i = 0; i < N; i++) {
			String str = sc.next();// String으로 한줄 입력받기
			String[] input = str.split("");// 한개씩 분리해서 배열에 넣기
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);// 정수형으로 형변환 뒤 배열에 값넣기
			}
		}

		// 사방탐색 재귀 -----------------------------------------------------------------
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) { // 1이면서 방문하지 않은것이면
					Recursive(i, j); // 재귀 탐색
					count++; // 다음 단지로 이동
				}
			}
		}

		// 출력부-----------------------------------------------------------------------
		// 총 단지 수
		System.out.println(count - 1);
		// 각단지 내 집의 수
		int result[] = new int[count];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					result[map[i][j]]++;// result의 인덱스값 = 단지별 번호
			}
		}
		Arrays.sort(result);// 정렬

		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}

		// ---------------
		//printMap();
		//System.out.println();
		//printResult(result);
	}

	public static void Recursive(int r, int c) {
		map[r][c] = count; // 방문한 집 표시
		visit[r][c] = true;

		// 상하좌우로 이동하며 탐색
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 배열의 범위를 벗어나지 않는 범위 내에서 탐색
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (map[nr][nc] == 1 && !visit[nr][nc]) { // 1이면서 방문하지 않은곳
					Recursive(nr, nc); // 단지 탐색(사방탐색)
				}
			}
		}
	}

	public static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printResult(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}
