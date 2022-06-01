package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Work implements Comparable<Work> {
	int d, t;

	public Work(int d, int t) {
		super();
		this.d = d;
		this.t = t;
	}

	@Override
	public int compareTo(Work o) {
		// TODO Auto-generated method stub
		return o.t - this.t;
	}

}

public class BOJ_7983 {

	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int d,t;
		
		String str;
		str = br.readLine();
		n = Integer.parseInt(str);
		PriorityQueue<Work> PQ  = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			d = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			PQ.add(new Work(d,t));
		}
		int lastday = 1000000000;
		
		while(!PQ.isEmpty()) {
			Work tempwork = PQ.poll();
			if(tempwork.t < lastday) {
				lastday = tempwork.t - tempwork.d;
			}else {
				lastday -= tempwork.d;
			}
		}
		System.out.println(lastday);
	}

}
