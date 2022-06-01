package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ_2156 {
	static int N;
	static int[] warray;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 계획서
		 * dp문제라고 생각함.
		 * 이전에 마신 포도주의 최댓값을 배열에 저장함.
		 * 배열에는 연속하지 않을 경우(마시지 않는 경우), 처음 마시는 경우, 두번째 마시는 경우를 저장합니다.
		 * 결과는 배열의 마지막 3가지 경우의 수 중 최댓값을 선택하면 됨.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		warray = new int [N];
		for(int i=0;i<N;i++) {
			warray[i] = Integer.parseInt(br.readLine());
		}
		int result = DP();
		System.out.println(result);
	}
	public static int DP() {
		int temparr[][] = new int [N][3];
		//초기값 설정.
		temparr[0][0] = 0;
		temparr[0][1] = warray[0];
		temparr[0][2] = warray[0];
		for(int i=1;i<N;i++) {
			temparr[i][0] = Math.max(temparr[i-1][0], Math.max(temparr[i-1][1], temparr[i-1][2]));
			temparr[i][1] = temparr[i-1][0] + warray[i];
			temparr[i][2] = temparr[i-1][1] + warray[i];
		}
		return Math.max(temparr[N-1][0], Math.max(temparr[N-1][1], temparr[N-1][2]));
	}
}
