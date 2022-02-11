package week2_2.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {
	public static int[][] map;
	public static boolean [][] check;
	public static int [][] dr = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size;
		String stemp;
		int count = 0;
		int[] sizearr;
		int c,r;
		int [] iatemp;
		int tempsize;
		Queue<Integer> sizeq = new LinkedList<>();
		Queue<int[]> indexq = new LinkedList<>();
		size =Integer.parseInt(br.readLine());
		map = new int [size][size];
		check = new boolean [size][size];
		for (int i = 0; i < size; i++) {
			stemp = br.readLine();
			for (int j = 0; j < size; j++) {
				map[i][j] = stemp.charAt(j) - '0';
			}
		}
		for(int i=0;i<size;i++) {
			for (int j = 0; j < size; j++) {
				if(map[i][j] == 1 && check[i][j] == false) {
					tempsize = 0;
					count++;
					check[i][j] = true;
					indexq.offer(new int[] {i,j});
					while(!indexq.isEmpty()) {
						iatemp = indexq.poll();
						c = iatemp[0];
						r = iatemp[1];

						tempsize++;
						for(int k=0;k<4;k++) {
							if(c+dr[k][0] >= 0 && c+dr[k][0] <size  && r+dr[k][1] >=0&& 
									r+dr[k][1] <size && map[c+dr[k][0]][r+dr[k][1]] == 1 && check[c+dr[k][0]][r+dr[k][1]] == false) {
								check[c+dr[k][0]][r+dr[k][1]] = true;
								indexq.offer(new int [] {c+dr[k][0],r+dr[k][1]});
							}
						}
						
					}
					sizeq.offer(tempsize);
				}
			}
		}
		sizearr = new int[count];
		for(int i=0;i<count;i++) {
			sizearr[i] = sizeq.poll();
		}
		Arrays.sort(sizearr);
		System.out.println(count);
		for(int i=0;i<count;i++) {
			System.out.println(sizearr[i]);
		}
	}
	
}
