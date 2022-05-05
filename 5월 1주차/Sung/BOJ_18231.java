package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_18231 {
	static int N,M;
	static ArrayList<Integer> [] link;
	static int K;
	static int destapt[];
	static boolean dest[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dest = new boolean [N];
		link = new ArrayList[N];
		for(int i=0;i<N;i++) {
			link[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int app1,app2;
			app1 = Integer.parseInt(st.nextToken()) - 1;
			app2 = Integer.parseInt(st.nextToken()) - 1;
			
			
			link[app1].add(app2);
			link[app2].add(app1);
			
		}
		K = Integer.parseInt(br.readLine());
		destapt = new int [K];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			destapt[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		sol();
		
		
	}
	private static void sol() {
		int count = 0;
		ArrayList<Integer> boomapp = new ArrayList<>();
		for(int i=0;i<K;i++) {
			boolean flag = true;
			for(int j=0;j<link[destapt[i]].size();j++) {
				boolean flag2 = false;
				int to = link[destapt[i]].get(j);
				for(int k=0;k<K;k++) {
					if(to == destapt[k]) {
						flag2 = true;
						break;
					}
				}
				if(!flag2) {
					flag = false;
					break;
				}
			}
			if(flag) {
				dest[destapt[i]] = true;
				for(int j=0;j<link[destapt[i]].size();j++) {
					dest[link[destapt[i]].get(j)] = true;
				}
				count++;
				boomapp.add(destapt[i]);
			}
		}
//		System.out.println(Arrays.toString(dest));
		for(int i=0;i<K;i++) {
			if(!dest[destapt[i]]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(count);
		for(int i=0;i< boomapp.size();i++) {
			System.out.print((boomapp.get(i)+1) + " ");
		}
		
	}

}
