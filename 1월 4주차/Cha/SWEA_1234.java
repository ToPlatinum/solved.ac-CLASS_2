import java.util.Scanner;

/** SW Expert D3 1234 비밀번호 **/
public class SWEA_1234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case < 2; test_case++) {
			int str_leng = sc.nextInt();
			String str = sc.next();

			// System.out.println(str_leng+" "+str);

			boolean flag = true;

			while (flag) {
				flag = false;
				for (int i = 0; i < str.length() - 1; i++) {
					if (str.charAt(i) == str.charAt(i + 1)) {
						String tmp = str.charAt(i) + "" + str.charAt(i);
						str = str.replace(tmp, "");
						// System.out.println(tmp);
						i--;
						flag = true;
					}
				}
			}
			System.out.println("#"+test_case+" "+str);
		}
	}

}
