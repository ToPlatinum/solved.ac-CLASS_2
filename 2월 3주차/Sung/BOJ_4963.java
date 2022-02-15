package week2_3.baekjoon;

import java.io.*;
import java.util.*;
public class BOJ_4963 {

	static int map[][];
	static int csize, rsize;
	static boolean check[][];
	static int[] dc = { -1, 0, 1, 0 ,-1,-1,1,1};
	static int[] dr = { 0, 1, 0, -1 ,-1,1,-1,1};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		rsize = Integer.parseInt(st.nextToken());
		csize = Integer.parseInt(st.nextToken());
		while(csize != 0 || rsize != 0) {
			map = new int [csize][rsize];
			check = new boolean[csize][rsize];
			
			for (int i = 0; i < map.length; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println(s1());
			
			
			str = br.readLine();
			st = new StringTokenizer(str);
			rsize = Integer.parseInt(st.nextToken());
			csize = Integer.parseInt(st.nextToken());
		}
		
		

	}
	public static int s1() {
		int countarea = 0;
		Queue<int []>indexq = new LinkedList<>();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				
				if(map[i][j]!= 0 && check[i][j] == false) {
					check[i][j] = true;
					
					countarea++;
					indexq.add(new int[] {i,j});
					while(!indexq.isEmpty()) {
						
						int [] recidx = new int[2];
						recidx = indexq.poll();
						int c,r;
						c = recidx[0];
						r = recidx[1];
						for(int d = 0;d<8;d++) {
							int ccurr,rcurr;
							ccurr = c+dc[d];
							rcurr = r+dr[d];
							if(ccurr>=0 && rcurr >=0 &&ccurr<csize && rcurr<rsize &&
									map[ccurr][rcurr] != 0 && check[ccurr][rcurr] == false) {
								indexq.add(new int [] {ccurr,rcurr});
								check[ccurr][rcurr] = true;
							}
						}
					}
				}
				
			}
		}
		return countarea;
	}


}
