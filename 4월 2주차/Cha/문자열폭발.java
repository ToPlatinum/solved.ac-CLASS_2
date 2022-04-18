package algostudy;

import java.util.Scanner;

/*
 * 20220419
 * 백준 : 9935 문자열폭발
 */
public class 문자열폭발 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 원래문자열
		String str = sc.next();
		// 폭발문자열
		String bomb = sc.next();

		// 스트링빌더
		StringBuilder sb = new StringBuilder();

		// 원래문자열길이만큼 반복하면서
		for (int i = 0; i < str.length(); i++) {
			// 한개씩 sb에 달아조
			char tmp = str.charAt(i);
			sb.append(tmp);

			// sb에 달다가 폭발 문자열길이 이상이 되면
			if (sb.length() >= bomb.length()) {
				boolean fire = true;
				// 폭발문자열길이 인지 검사해
				for (int j = 0; j < bomb.length(); j++) {
					//
					char a = sb.charAt(sb.length() - bomb.length() + j);
					//System.out.print ("a: " + a+" ");
					char b = bomb.charAt(j);
					//System.out.println("b: " + b);
					if (a != b) {
						fire = false;
						break;
					}
				}
				if (fire) {
					sb.delete(sb.length() - bomb.length(), sb.length());
				}
			}
		}
		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb.toString());
		}

	}

}
