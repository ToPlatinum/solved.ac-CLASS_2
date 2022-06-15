package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1916 {
	static ArrayList<int[]> link[];
	static int N;
	static int M;
	static int min[];
	static boolean v[];

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int start, end;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		min = new int[N];
		v = new boolean[N];
		link = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			link[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from, to;
			int weight;
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken()) - 1;
			to = Integer.parseInt(st.nextToken()) - 1;
			weight = Integer.parseInt(st.nextToken());
			link[from].add(new int[] { to, weight });
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < N; i++) {
			if (i != start) {
				min[i] = Integer.MAX_VALUE;
			}
		}
		int result = solution(start, end);
		System.out.println(result);
	}

	private static int solution(int start, int end) {
		for(int i=0;i<N;i++) {
			int minval = Integer.MAX_VALUE;
			int minindex = 0;
			for(int j=0;j<N;j++) {
				if(!v[j] && minval > min[j]) {
					minval = min[j];
					minindex = j;
				}
			}
			
//			System.out.println(minindex);
			
			v[minindex] = true;
			
			for(int j=0;j<link[minindex].size();j++) {
				int[] arr = link[minindex].get(j);
				if(!v[arr[0]] && min[arr[0]] > (min[minindex] + arr[1])) {
					min[arr[0]] = min[minindex] + arr[1];
					
				}
			}
		}
		return min[end];
	}
}
