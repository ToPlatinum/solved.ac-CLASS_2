package date_2022_01_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String [] sarr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		int count = s.length();
		boolean flag = false;
		for(int i=0;i<s.length();i++) {
			for(int j = 0;j<8;j++) {
				flag = true;
				for(int k=0;k<sarr[j].length();k++) {
					if(i+k==s.length() || s.charAt(i+k) != sarr[j].charAt(k)) {
						flag = false;
						break;
					}
					
				}
				if(flag == true) {
					count-= (sarr[j].length() - 1);
					i += (sarr[j].length() -1);
					break;
				}
			}
			
		}
		System.out.println(count);
		
	}

}
