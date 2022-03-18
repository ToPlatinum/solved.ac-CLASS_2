package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1504 {
	static ArrayList<int[]>[] link;
	static int N, E;
	static int[] IV = new int[2];
	static boolean[] v = new boolean[2];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		link = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			link[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			link[n1].add(new int[] { n2, val });
			link[n2].add(new int[] { n1, val });
		}
		st = new StringTokenizer(br.readLine());
		IV[0] = Integer.parseInt(st.nextToken());
		IV[1] = Integer.parseInt(st.nextToken());
		int result = per(new int [2], 0);
		if(result == Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
		System.out.println(result);
	}

	public static int per(int[] sel, int count) {
		int result = Integer.MAX_VALUE;
		int itemp;
		if (count == 2) {
			int tor = 0;
			int start = 1;
			int end = N;
			int itemp2;
			for (int i = 0; i < 2; i++) {
				itemp2 = dijk(start, sel[i]);
				
				if (itemp2 == Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				tor += itemp2;
				start = sel[i];
			}
			itemp2 = dijk(sel[1], end);
			if (itemp2 == Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			tor += itemp2;
			
			return tor;
		}

		for (int i = 0; i < 2; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[count] = IV[i];
				itemp = per(sel, count + 1);
				result = Math.min(result, itemp);
				v[i] = false;
			}
		}
		return result;
	}

	public static int dijk(int start, int end) {
		int[] minval = new int[N + 1];
		boolean[] vi = new boolean[N + 1];
		int min = Integer.MAX_VALUE;
		int minidx = 0;
		Arrays.fill(minval, Integer.MAX_VALUE);
		minval[start] = 0;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			minidx = 0;
			for (int j = 1; j < N + 1; j++) {
				if (!vi[j] && minval[j] < min) {
					min = minval[j];
					minidx = j;
				}
			}
			if(minidx == end) {
				return minval[end];
			}
			vi[minidx] = true;
			for(int j=0;j<link[minidx].size();j++) {
				int to = link[minidx].get(j)[0];
				int val = link[minidx].get(j)[1];
				if(!vi[to] && minval[to] > minval[minidx] + val) {
					minval[to] = minval[minidx] + val;
					
				}
			}
		}
		return minval[end];

	}

}
