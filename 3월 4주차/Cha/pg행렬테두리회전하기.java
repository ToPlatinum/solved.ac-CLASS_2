package algostudy;

import java.util.Arrays;

class pg행렬테두리회전하기 {

	static int[][] matrix;

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };

		matrix = new int[rows][columns];
		int[] answer = new int[queries.length];

		// 행렬 값 때려넣기
		int value = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = value++;
			}
		}
		print();
		// 한줄씩 보내
		for (int i = 0; i < 1; i++) {
			answer[i] = rotate(queries[i]);
			// System.out.println("회전 : " + (i + 1));
			// print();
		}

		System.out.println(Arrays.toString(answer));
	}

	public static int rotate(int[] query) {
		// 시작 행,열
		int r1 = query[0] - 1;
		int c1 = query[1] - 1;
		// 끝 행,열
		int r2 = query[2] - 1;
		int c2 = query[3] - 1;

		// 시작 행, 열값 저장
		int temp = matrix[r1][c1];

		// 최솟값으로 설정
		int min = temp;

		// 맨왼쪽을 위로 올려
		for (int i = r1; i < r2; i++) {
			matrix[i][c1] = matrix[i + 1][c1];
			if (min > matrix[i][c1])
				min = matrix[i][c1];
		}
		// print();
		// 맨아래를 왼쪽으로 땡겨
		for (int i = c1; i < c2; i++) {
			matrix[r2][i] = matrix[r2][i + 1];
			if (min > matrix[r2][i])
				min = matrix[r2][i];
		}
		// print();
		// 맨오른쪽을 한칸 내려
		for (int i = r2; i > r1; i--) {
			matrix[i][c2] = matrix[i - 1][c2];
			if (min > matrix[i][c2])
				min = matrix[i][c2];
		}
		// print();
		// 맨윗줄을 오른쪽으로 당기고 temp넣기
		for (int i = c2; i > c1; i--) {
			matrix[r1][i] = matrix[r1][i - 1];
			if (min > matrix[r1][i])
				min = matrix[r1][i];
		}
		matrix[r1][c1 + 1] = temp;
		// print();
		return min;
	}

	public static void print() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}