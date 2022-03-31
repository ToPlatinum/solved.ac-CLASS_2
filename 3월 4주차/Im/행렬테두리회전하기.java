package lv_1;

import java.util.Arrays;

public class 행렬테두리회전하기 {

	public static void main(String[] args) {
//		rows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다. 
//		이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다. 
//		각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.
//		x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.

		int rows1 = 6;
		int columns1 = 6;
		int[][] queries1 = new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };

		int rows2 = 3;
		int columns2 = 6;
		int[][] queries2 = new int[][] { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2, 3, 3 } };

		int rows3 = 100;
		int columns3 = 6;
		int[][] queries3 = new int[][] { { 1, 1, 100, 97 } };
		System.out.println(Arrays.toString(solution(rows1, columns1, queries1)));
	}

	private static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		// 배열 생성
		int[][] map = new int[rows][columns];
		int[][] tempmap = new int[rows][columns];
		int cnt = 1;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				map[r][c] = cnt;
				tempmap[r][c] = cnt++;
			}
		}
//		System.out.println(map[2-1][2-1]);
//		System.out.println(map[5-1][4-1]);
		// 쿼리만큼 반복
		for (int i = 0; i < queries.length; i++) {
			int r1 = queries[i][0] - 1;
			int c1 = queries[i][1] - 1;
			int r2 = queries[i][2] - 1;
			int c2 = queries[i][3] - 1;
//			System.out.println(r1 + " " + c1);
//			System.out.println(map[r1][c1]);
//			System.out.println(r2 + " " + c2);
//			System.out.println(map[r2][c2]);
			// 배열 돌리기
			// 돌리기 위한 임시값 저장(가장 마지막에 넣어줌)
			int temp = map[r1][c1];
			// 최소값 초기화(마지막에 넣는 값도 비교해주기위해 여기 넣어줌)
			int min = temp;
			// 첫 회전(총 4번중 1)
			for (int r = r1 + 1; r <= r2; r++) {
				map[r - 1][c1] = map[r][c1];
				min = Math.min(min, map[r][c1]);
			}
			// 두번째 회전(총 4번중 2)
			for (int c = c1 + 1; c <= c2; c++) {
				map[r2][c - 1] = map[r2][c];
				min = Math.min(min, map[r2][c]);
			}

			// 세번째 회전(총 4번중 3)
			for (int r = r2 - 1; r >= r1; r--) {
				map[r + 1][c2] = map[r][c2];
				min = Math.min(min, map[r][c2]);
			}

			// 네번째 회전(총 4번중 4)
			for (int c = c2 - 1; c >= c1; c--) {
				map[r1][c + 1] = map[r1][c];
				min = Math.min(min, map[r1][c]);
			}
			// 벌레처럼 줄지어 이동했으니 이제 마지막 값에 temp넣어줌
			map[r1][c1+1] = temp;
			answer[i] = min;
//			print(map);
//			System.out.println("한바퀴 돌림");
		}
		return answer;
	}

	public static void print(int[][] map) {
		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
