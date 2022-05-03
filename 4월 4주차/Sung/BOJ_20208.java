package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20208 {
	static int[] start;
	static int N, M, H;
	static ArrayList<int[]> milks;
	static int[] sel;
	static int milkcount;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		milks = new ArrayList<>();
		milkcount = 0;
		start = new int[2];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 2) {
					milks.add(new int[] { r, c });
					milkcount++;
				} else if (temp == 1) {

					start[0] = r;
					start[1] = c;
				}
			}
		}
		sel = new int[milkcount];
		int result = per(0, 0);
		System.out.println(result);
	}

	private static int per(int v, int cnt) {
		if (cnt == milkcount) {
			return calcul();
		}
		int result = 0;
		int itemp;
		for (int i = 0; i < milkcount; i++) {
			if ((v & 1 << i) == 0) {
				sel[cnt] = i;
				itemp = per(v | 1 << i, cnt + 1);
				result = Math.max(result, itemp);
			}
		}
		return result;
	}

	private static int calcul() {
		int result = 0;
		int energy = M;
		int[] temp = start;
		int[] curr = start;
		for (int i = 0; i < milkcount; i++) {
			curr = milks.get(sel[i]);
			int dist = Math.abs(temp[1] - curr[1]) + Math.abs(temp[0] - curr[0]);
			if (energy < dist) {
				return result;
			}
			energy -= dist;
			energy += H;
			temp = curr;
			int gohome = Math.abs(start[1] - curr[1]) + Math.abs(start[0] - curr[0]);
			if(gohome <= energy) {
				result = i + 1;
			}
		}
		return result;
	}

}
