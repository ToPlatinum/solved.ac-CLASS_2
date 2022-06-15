package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1041 {
	static int N;
	static int dice[][];
	static int min[];
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dice = new int[2][3];
		min = new int [3];
		for(int i=0;i<3;i++) {
			min[i] = Integer.MAX_VALUE;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<2;i++) {
			for(int j=0;j<3;j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
				if(dice[i][j] < min[0]) {
					min[0] = dice[i][j];
				}
				if(dice[i][j] > max) {
					max = dice[i][j];
				}
			}
		}
		find2d();
		find3d(0,0);
		long result = calres();
//		for(int i=0;i<3;i++) {
//			System.out.println(min[i] + " : ");
//		}
		System.out.println(result);
	}

	private static long calres() {
		long result = 0;
		if(N==1) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<3;j++) {
					result +=dice[i][j];
				}
				
			}
			return result - max;
		}
		result+= ((long)(5*N-6) * (N-2) * min[0]);
		result+= ((long)(N-1) * 4 * min[1] + (long)(N-2) * 4 * min[1]);
		result+= (4 * min[2]);
		return result;
	}

	private static void find3d(int count, int sel) {
		if(count == 3) {
//			System.out.println(sel);
			int sum = 0;
			for(int i=0;i<3;i++) {
				if((sel & 1<<i)!=0) {
					sum+=dice[1][i];
				}else {
					sum+=dice[0][2-i];
				}
			}
			if(min[2] > sum) {
				min[2] = sum;
			}
			return;
		}
		find3d(count+1 , sel | 1<<count);
		find3d(count+1 , sel);
		
		
	}

	private static void find2d() {
		// TODO Auto-generated method stub
		for(int i1=0;i1<2;i1++) {
			for(int j1=0;j1<3;j1++) {
				int first = dice[i1][j1];
				for(int i2=0;i2<2;i2++) {
					for(int j2=0;j2<3;j2++) {
						int second = dice[i2][j2];
						if(!(i1 == i2 && j1 == j2) &&!(i1 != i2 && 2-j1 == j2) && min[1]  > first + second) {
							min[1] = first + second;
						}
					}
				}
			}
		}
	}

}
