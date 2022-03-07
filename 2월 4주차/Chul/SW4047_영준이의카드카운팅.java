package IMadd;

import java.util.*;
import java.io.*;

public class SW4047_영준이의카드카운팅 {

	static int[][] map;//입력받은 카드배열
	static boolean check;//가지고 있는 카드랑 체크 //boolean[] boolean 쓸 때 차이
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/4047_input.txt"));
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {//testcase 받기	
			
		map = new int[4][14];//S,D,H,C 구분 
		int s_cnt = 0;
		int d_cnt = 0;
		int h_cnt = 0;
		int c_cnt = 0;
		
		String TXY = sc.next();//입력값 설정
		//문자열 3개씩 나눠서 받기
		for (int i = 0; i < TXY.length(); i+=3) {
			String tx = TXY.substring(i,i+3);//3번째까지 자르기
			char C = tx.charAt(0); //문자받아서 구분
			int N = Integer.parseInt(TXY.substring(1,3));//숫자입력받기

			//받은 문자열 SDHC 구분
			if(tx.equals("S")) { //문자열이 S와 같으면 S배열 추가
				map[0][N]++;
			}else if(tx.equals("D")) { //문자열이 D와 같으면 D배열 추가
				map[1][N]++; 
			}else if(tx.equals("H")) { //문자열이 H와 같으면 H배열 추가
				map[2][N]++;
			}else if(tx.equals("C")) { //문자열이 C와 같으면 C배열 추가
				map[3][N]++;
			}
	
		//결과값 출력
		int count = 0;
			for (int j = 1; j < 14; j++) {
				if(map[0][j]>1||map[1][j]>1||map[2][j]>1||map[3][j]>1) {
					count=1;
					System.out.printf("#d ERROR", tc);
					break;
				}	
				if(map[0][j] == 0)
					s_cnt++;
				if(map[1][j] == 0)
					d_cnt++;
				if(map[2][j] == 0)
					h_cnt++;
				if(map[3][j] == 0)
					c_cnt++;
			}		
			if(count == 0) {
				System.out.printf("#%d %d %d %d %d", tc, s_cnt, d_cnt, h_cnt, c_cnt );
				System.out.println();
			}
		  }
		}
	}
}
