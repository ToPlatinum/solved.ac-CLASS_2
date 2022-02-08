package m1week5;

//재미있는 오셀로 게임
import java.util.Scanner;

public class SWEA_4615 {
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();// 테스트 케이스

		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();// 보드 크기
			board = new int[N][N];// 보드 생성

			int M = sc.nextInt();// 플레이어가 돌을 놓는 횟수

			int black = 0, white = 0;// 검정돌, 흰돌 카운트

			// 초기세팅 검정돌1 흰돌2
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2] = 2;

			// 돌 놓는 횟수만큼
			for (int j = 0; j < M; j++) {
				int x = sc.nextInt() - 1;// x좌표
				int y = sc.nextInt() - 1;// y좌표
				int color = sc.nextInt();// 돌색

				board[x][y] = color;
				game(N, x, y, color);
			}

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (board[j][j2] == 1)
						black++;
					else if (board[j][j2] == 2)
						white++;
				}
			}
			 System.out.println("#" + i + " " + black + " " + white);
		}
	}

	public static void game(int N, int x, int y, int color) {
		for (int a = -1; a <= 1; a++) { // 8방탐색
			for (int b = -1; b <= 1; b++) {
				if (a == 0 && b == 0)// 제외
					continue;

				// 좌표갱신
				int nx = x + a;
				int ny = y + b;

				boolean check = false; // 자신의 돌인지

				// 경계값 확인 및 돌색 확인
				while (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] != 0) {
					if (board[nx][ny] == color) { // 자신의 돌일 경우
						check = true;
						break;
					}
					nx += a; // 상대의 돌일 경우
					ny += b;
				}

				while (check) {
					if (nx == x && ny == y)
						break;
					board[nx][ny] = color; // 상대돌빼고 내돌놓기
					nx -= a;
					ny -= b;
				}
			}
		}

	}
}
