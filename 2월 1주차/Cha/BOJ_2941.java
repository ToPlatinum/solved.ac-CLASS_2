package m2week1;

//백준 크로아티아 알파벳
import java.util.Scanner;

public class BOJ_2941 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String str[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		for (int i = 0; i < str.length; i++) {
			if (s.contains(str[i])) {
				s = s.replace(str[i], "1");
			}
		}
		System.out.println(s.length());
	}

}
