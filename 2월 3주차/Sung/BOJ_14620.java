package week2_3.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14620 {
	static int[] dc = { -1, 0, 1, 0 };
	static int[] dr = { 0, 1, 0, -1 };
static int N;
	static class Data implements Comparable<Data> {
		int indexx, indexy, area;

		
		public Data(int indexx, int indexy, int area) {
			super();
			this.indexx = indexx;
			this.indexy = indexy;
			this.area = area;
		}


		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return o.area - this.area;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int count = 0;
		int[][] map;
		int itemp;
		N = Integer.parseInt(br.readLine());
		Data[] datas = new Data[(int) Math.pow(N - 2, 2)];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<N-1;j++) {
				itemp = map[i][j];
				for(int d=0;d<4;d++) {
					itemp +=map[i + dc[d]][j + dr[d]];
				}
				datas[count++] = new Data(i,j,itemp); 
			}
		}
		Arrays.sort(datas);
		int result = per(datas, 0, new Data[3], 0);
		System.out.println(result);
	}
	public static int per(Data[] datas, int start, Data[] sel, int index) {
		int result = 1000000000;
		int itemp;
		if(index == sel.length) {
			return check(sel);
		}
		for(int i=start;i<datas.length;i++) {
			sel[index] = datas[i];
			itemp = per(datas, i+1, sel, index + 1);
			if(itemp < result) {
				result = itemp;
			}
		}
		return result;
		
	}
	public static int check(Data [] sel) {
		boolean flag = true;
		
		if(Math.abs(sel[0].indexx - sel[1].indexx) + Math.abs(sel[0].indexy - sel[1].indexy) <=2) {
			flag = false;
		}
		
		if(Math.abs(sel[1].indexx - sel[2].indexx) + Math.abs(sel[1].indexy - sel[2].indexy) <=2) {
			flag = false;
		}
		
		if(Math.abs(sel[2].indexx - sel[0].indexx) + Math.abs(sel[0].indexy - sel[2].indexy) <=2) {
			flag = false;
		}
		if(flag == false) {
			return 1000000000;
		}
		return sel[0].area + sel[1].area + sel[2].area;
	}

}
