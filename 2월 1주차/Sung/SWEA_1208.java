package date_2022_01_31;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SWEA_1208 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String recstr;
		String Tockens[];
		int test_case = 10;
		int dump;
		int [] boxes = new int [100];
		int max = 0;
		int min = 1000;
		int maxindex = 0;
		int minindex = 0;
		for(int tc = 0;tc<test_case;tc++) {
			
			
			dump = Integer.parseInt(br.readLine());
			System.out.println(dump);
			recstr = br.readLine();
			Tockens = recstr.split(" ");
			System.out.println(Tockens.length);
			for(int i=0;i<Tockens.length;i++) {
				boxes[i] = Integer.parseInt(Tockens[i]);
				System.out.print(boxes[i] + ", ");
				
			}
			System.out.println();
			for(int count = 0;count<dump;count++) {
				max = 0;
				min = 1000;
				for(int i = 0;i<100;i++) {
					if(boxes[i] > max) {
						max = boxes[i];
						maxindex = i;
					}
					if( boxes[i] < min ) {
						min = boxes[i];
						minindex = i;
					}
				}
				boxes[maxindex]--;
				boxes[minindex]++;
				
			}
			max = 0;
			min = 1000;
			for(int i = 0;i<100;i++) {
				
				System.out.print(boxes[i] + ", ");
				if(boxes[i] > max) {
					max = boxes[i];
				}
				if( boxes[i] < min ) {
					min = boxes[i];
				}
			}
			System.out.println();
			System.out.println(max +  ", " + min);
			System.out.println("#" + tc + " " + (max - min));
			
		}
		
	}

}
