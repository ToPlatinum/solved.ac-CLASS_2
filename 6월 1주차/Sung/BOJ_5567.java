package beakjoon;

import java.io.*;
import java.util.*;

public class BOJ_5567 {
	static int N;
	static ArrayList<Integer>[] link;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int linknum;
		N = Integer.parseInt(br.readLine());
		link = new ArrayList[N];
		for(int i=0;i<N;i++) {
			link[i] = new ArrayList<>();
		}
		linknum = Integer.parseInt(br.readLine());
		
		for(int i=0;i<linknum;i++) {
			st = new StringTokenizer(br.readLine());
			int p1,p2;
			p1 = Integer.parseInt(st.nextToken()) - 1;
			p2 = Integer.parseInt(st.nextToken()) - 1;
			link[p1].add(p2);
			link[p2].add(p1);
		}
		int result = map();
		System.out.println(result);
	}
	private static int map() {
		Queue<Integer> Q = new LinkedList<>();
		boolean v[] = new boolean[N];
		Q.add(0);
		v[0] = true;
		int level = 0;
		int count = -1;
		while(!Q.isEmpty()) {
			if(level > 2) {
				return count;
			}
			int size = Q.size();
			for(int s=0;s<size;s++) {
				int person = Q.poll();
				count++;
				for(int f=0;f<link[person].size();f++) {
					if(!v[link[person].get(f)]) {
						Q.add(link[person].get(f));
						v[link[person].get(f)] = true;
					}
				}
			}
			level++;
		}
		return count;
	}

}
