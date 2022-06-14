import java.util.*;
//노드간의 거리 1번과 1,2인 거리 count

public class bj_5567_결혼식 {
	public static int N;
	public static int[][] map;
	public static boolean[] visited;
	public static int count;
	public static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		num = new int[N + 1];

		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}

		bfs(1);
		count = 0;
		for (int i = 1; i < num.length; i++) {
			if (3 > num[i] && num[i] >= 1) {
				count += 1;
			}
		}
		System.out.println(count);

	}

	public static void bfs(int v) {
		Queue<Integer> Q = new LinkedList<>();
		visited[v] = true;
		Q.offer(v);
		while (!Q.isEmpty()) {
			int poll = Q.poll();
			for (int i = 1; i < map[poll].length; i++) {
				if (map[poll][i] == 1 && !visited[i]) {
					Q.offer(i);
					visited[i] = true;
					num[i] = num[poll] + 1;
				}
			}
		}
	}
}
