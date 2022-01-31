package date_2022_01_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1974 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String recstr;
		String[] tockens;
		int test_case;
		int map[][] = new int[9][9];
		int intarr[] = new int[9];
		int intarr2[] = new int[9];
		boolean flag = true;

		test_case = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < test_case; tc++) {
			flag = true;
			for (int i = 0; i < 9; i++) {
				recstr = br.readLine();
				tockens = recstr.split(" ");
				for (int j = 0; j < tockens.length; j++) {
					map[i][j] = Integer.parseInt(tockens[j]);
				}
			}
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					intarr[j] = 0;
					intarr2[j] = 0;
				}
				for (int j = 0; j < 9; j++) {
					intarr[map[i][j]-1]++;
					intarr2[map[j][i]-1]++;
					if (intarr[map[i][j]-1] == 2) {
						flag = false;
						break;
					}
					if (intarr2[map[j][i]-1] == 2) {
						flag = false;
						break;
					}
				}
				if (flag == false) {
					break;
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int k = 0; k < 3; k++) {
					for (int j = 0; j < 9; j++) {
						intarr[j] = 0;
					}
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							intarr[map[3 * i + c][3 * k + r]-1]++;
							if (intarr[map[3 * i + c][3 * k + r]-1] == 2) {
								flag = false;
							}
						}
					}

				}
			}
			System.out.print("#" + (tc+1) + " ");
			if(flag == true) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
	}

}
