package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] table = new int[N];
			for (int i = 0; i < N; i++) {
				int h = Integer.parseInt(st.nextToken());
				table[i] = h;
			}
			//탐색 시작
			int maxHigh = 0;
			int result = 0;
			for (int i = 2; i < N-2; i++) {
				//해당 위치에서 좌 우 2칸씩에 있는 빌딩들의 높이 구하기
				//그리고 그 높이가 현재 위치의 높이보다 낮으면
				//얼마나 낮은지를 결과값에 더해준다.
				maxHigh = Math.max(Math.max(table[i-1], table[i-2]), Math.max(table[i+1], table[i+2]));
				if(maxHigh < table[i]) {
					result += table[i]-maxHigh;
				}
			}
			System.out.printf("#%d %d\n",tc,result);
		}
	}

}
