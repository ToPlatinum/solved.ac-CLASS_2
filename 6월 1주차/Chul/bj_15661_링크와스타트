import java.util.Scanner;

//완탐
public class bj_15661_링크와스타트 {
	public static int[][] map; // 선수들의 능력치를 입력할 2차원 배열
	public static boolean[] team; // start 팀과 link 팀을 각각 true와 false로 나눔
	public static int N;
	public static int min = Integer.MAX_VALUE;


	public static void teamSelect() {
		int t_St = 0; //팀 스타트
		int t_Li = 0; //팀 링크

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue; //제외
				if (team[i] && team[j])
					t_St += map[i][j];
				// true면 St
				if (!team[i] && !team[j])
					t_Li += map[i][j];
				// false면 Li
			}
		}
		min = Math.min(min, Math.abs(t_Li - t_St));
	}

	public static void backTracking(int index, int count) {
		if (count == N / 2) { // 팀을 나눈다?
			teamSelect(); // 팀을 나눈다.
			return;
		}

		for (int i = index; i < N; i++) {
			team[i] = true;
			backTracking(i + 1, count + 1);
			team[i] = false;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		team = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		backTracking(0, 0);
		System.out.println(min);
	}
}
