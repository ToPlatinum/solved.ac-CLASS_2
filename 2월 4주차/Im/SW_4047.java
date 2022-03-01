package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW_4047 {
	static class Card {
		char shape;
		int num;

		public Card(char shape, int num) {
			super();
			this.shape = shape;
			this.num = num;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 맨 위 줄에 테스트케이스의 개수가 주어진다.
		int T = Integer.parseInt(br.readLine());
		L: for (int testCase = 1; testCase <= T; testCase++) {
			// 각 테스트케이스 별로 순서대로 첫 번째 줄에 지금 영준이가 가지고 있는 카드에 대한 정보 S (1 ≤ |S| ≤ 1000)가 주어진다.
			String temp = br.readLine();
			// S는 각각 3자리로 표현되는 카드들의 정보를 붙여서 만든 하나의 문자열인데 각 카드는 TXY 꼴로 표현되며,
			ArrayList<Card> list = new ArrayList<Card>();
			// S D H C
			int[] resultarr = { 13, 13, 13, 13 };
			for (int i = 0; i < temp.length(); i += 3) {
				char shape = temp.charAt(i);
				int num = Integer.parseInt(temp.substring(i + 1, i + 3));
				for (Card C : list) {
					if (C.shape == shape & C.num == num) {
						System.out.printf("#%d ERROR\n", testCase);
						continue L;
					}
//					System.out.printf("%c%d + %c%d\n", shape, num, C.shape, C.num);
				}
				list.add(new Card(shape, num));
				switch (shape) {
				case 'S':
					resultarr[0]--;
					break;
				case 'D':
					resultarr[1]--;
					break;
				case 'H':
					resultarr[2]--;
					break;
				case 'C':
					resultarr[3]--;
					break;

				}
			}
			System.out.printf("#%d ", testCase);
			for (int a : resultarr) {
				System.out.print(a + " ");
			}
			System.out.println();
		} // end TestCase
	}

}
