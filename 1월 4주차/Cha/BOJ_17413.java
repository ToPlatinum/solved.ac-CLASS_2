import java.util.Scanner;

public class BOJ_17413 {
	static String s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();// 공백까지 입력받아라.

		boolean tag = false;// 괄호 안인지

		int start = 0;// 시작 인덱스

		String temp;

		for (int i = 0; i < s.length(); i++) {
			// 태그안이 아니고 공백인 경우
			if (tag == false && s.charAt(i) == ' ') {
				temp = s.substring(start, i);// 단어하나
				// 뒤집어서 출력
				for (int j = temp.length() - 1; j >= 0; j--) {
					System.out.print(temp.charAt(j));
				}
				System.out.print(" ");
				start = i + 1;// 시작인덱스 업데이트
				// < 발견
			} else if (s.charAt(i) == '<') {
				tag = true;// 태그변수 true
				if (i != 0) {// 태그를 만나기 전에 단어가 있는 경우
					temp = s.substring(start, i);// 태그 만나기 전까지 잘라서
					// 뒤집어서 출력
					for (int j = temp.length() - 1; j >= 0; j--) {
						System.out.print(temp.charAt(j));
					}
				}
				start = i;// 시작인덱스 업데이트
				// 태그 닫힘
			} else if (s.charAt(i) == '>') {
				//태그 시작부터 닫힘까지 출력
				System.out.print(s.substring(start, i + 1));
				tag = false;//태그변수 false
				start = i + 1;//시작인덱스 업데이트
			}
		}
		//마지막 단어(태그 사이 아닌)
		if (start != s.length()) {
			temp = s.substring(start);
			for (int j = temp.length() - 1; j >= 0; j--) {
				System.out.print(temp.charAt(j));
			}
		}
	}

}