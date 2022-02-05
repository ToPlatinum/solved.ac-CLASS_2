package week2_1.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String recstr;
        int test_case;
        int count =0 ;
        recstr = br.readLine();
        test_case = Integer.parseInt(recstr);
        String reccode;
        char startc = '0';
        for(int tc = 0;tc<test_case;tc++) {
            count = 0;
            startc = '0';
            reccode = br.readLine();
            for(int i=0;i<reccode.length();i++) {
                if(reccode.charAt(i)!= startc) {
                    count++;
                    if(startc == '0') {
                        startc = '1';
                    }
                    else {
                        startc = '0';
                    }
                }
            }
            System.out.println("#" + (tc+1) + " " + count);
        }
	}

}
