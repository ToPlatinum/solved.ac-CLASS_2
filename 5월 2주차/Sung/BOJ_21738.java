package baekjoon;


import java.io.*;
import java.util.*;

public class BOJ_21738 {
	static int S, N, P;
	static ArrayList<Integer>[] blocks;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		str = br.readLine();
		st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken()) - 1;
		blocks = new ArrayList[N];
		for(int i=0;i<N;i++) {
			blocks[i] = new ArrayList<>();
		}
		int A,B;
		for(int i=0;i<N - 1;i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			A = Integer.parseInt(st.nextToken()) - 1;
			B = Integer.parseInt(st.nextToken()) - 1;
			blocks[A].add(B);
			blocks[B].add(A);
		}
		int result = bfs();
		System.out.println(N- result);
	}

	private static int bfs() {
		int result = 0;
		Queue<Integer> Q = new LinkedList<>();
		boolean[] v = new boolean[N];
		Q.add(P);
		v[P] = true;
		int count = 0;
		int level = 0;
		while(!Q.isEmpty()) {
			int size = Q.size();
			for(int s=0;s<size;s++) {
				int tempi = Q.poll();
				if(tempi < S) {
					count++;
					result+=level;
					if(count == 2) {
						return result+1;
					}
				}
				for(int i=0;i<blocks[tempi].size();i++) {
					if(!v[blocks[tempi].get(i)]) {
						Q.add(blocks[tempi].get(i));
						v[blocks[tempi].get(i)] = true;
					}
				}
			}
			level++;
		}
		return result+1;
	}

}
