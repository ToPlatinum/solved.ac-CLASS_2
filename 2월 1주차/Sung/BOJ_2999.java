package date_2022_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2999 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String recstr;
		int length;
		int R,C;
		char[][] carr;
		recstr = br.readLine();
		length = recstr.length();
		R = (int) Math.sqrt(length);
		
		while(R>0   &&   length % R != 0 ) {
			R--;
		}

		C = length/R;
		carr = new char[R][C];
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				carr[j][i] = recstr.charAt(i*R + j);
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(carr[i][j]);
			}
		}
	}

}
