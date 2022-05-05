package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922 {
	static int N,M;
	static ArrayList<Link>[] links;
	
	static class Link implements Comparable<Link>{
		int to,value;

		public Link(int to, int value) {
			super();
			this.to = to;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Link [to=" + to + ", value=" + value + "]";
		}

		@Override
		public int compareTo(Link o) {
			return this.value - o.value;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		links = new ArrayList[N];
		for(int i=0;i<N;i++) {
			links[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			int c1,c2,val;
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken()) - 1;
			c2 = Integer.parseInt(st.nextToken()) - 1;
			val = Integer.parseInt(st.nextToken());
			
			links[c1].add(new Link(c2,val));
			links[c2].add(new Link(c1,val));
		}
		int result = MST();
		System.out.println(result);
	}
	private static int MST() {
		int result = 0;
		PriorityQueue<Link> PQ = new PriorityQueue<>();
		boolean []v = new boolean [N];
		int index=0;
		v[0] = true;
		for(int i=0;i<N-1;i++) {
//			System.out.println(index);
			for(int j=0;j<links[index].size();j++) {
				if(!v[links[index].get(j).to]) {
					PQ.add(links[index].get(j));
				}
			}
//			System.out.println(links[index].size());
//			System.out.println(PQ.size());
			Link ltemp = PQ.poll();
			while(v[ltemp.to]) {
//				System.out.println(ltemp);
				ltemp = PQ.poll();
			}
			index = ltemp.to;
			result+=ltemp.value;
			v[index] = true;
		}
		
		
		
		return result;
	}

}
