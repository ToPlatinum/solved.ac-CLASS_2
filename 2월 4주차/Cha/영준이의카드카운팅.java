package Eight;

import java.util.Scanner;

/*
 * IM대비 2차
 * 20220225
 * D3 영준이의 카드카운팅
 * 
 * 카드 무늬만 판독해서 13에서 빼주기
 * 카드 무늬가 중복되면 뒤에 숫자 비교해주기
 */
public class 영준이의카드카운팅 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		loop: for (int tc = 1; tc <= T; tc++) {
			System.out.println("들어와쩡" + tc);
			String str = sc.next();
			String card = "";
			String newStr = "";
			boolean dupl = false;
			int idx = 0;
			// 카드 종류별 13장씩
			int S = 13;
			int D = 13;
			int H = 13;
			int C = 13;
			for (int i = 0; i < str.length() / 3; i++) {
				switch (str.charAt(idx)) {
				case 'S':
					S--;
					card = str.charAt(idx) + "" + str.charAt(idx + 1) + "" + str.charAt(idx + 2);
					newStr = str.replaceFirst(card, "");
					if (newStr.contains(card)) {
						dupl = true;
					}
					break;
				case 'D':
					D--;
					card = str.charAt(idx) + "" + str.charAt(idx + 1) + "" + str.charAt(idx + 2);
					newStr = str.replaceFirst(card, "");
					if (newStr.contains(card)) {
						dupl = true;
					}
					break;
				case 'H':
					H--;
					card = str.charAt(idx) + "" + str.charAt(idx + 1) + "" + str.charAt(idx + 2);
					newStr = str.replaceFirst(card, "");
					if (newStr.contains(card)) {
						dupl = true;
					}
					break;
				case 'C':
					C--;
					card = str.charAt(idx) + "" + str.charAt(idx + 1) + "" + str.charAt(idx + 2);
					newStr = str.replaceFirst(card, "");
					if (newStr.contains(card)) {
						dupl = true;
					}
					break;
				default:
					break;
				}
				idx += 3;
			}
			if (dupl == true) {
				System.out.println("#" + tc + " ERROR");
			} else {
				System.out.println("#" + tc + " " + S + " " + D + " " + H + " " + C);
			}

		}

	}

}
