package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1713_20220315 {

	static class Student{
		int vote;
		int date;
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Student(int vote, int date) {
			super();
			this.vote = vote;
			this.date = date;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cannum;
		int rec;
		Student [] students = new Student [101];
		for(int i=0;i<101;i++) {
			students[i] = new Student(0,0);
		}
		cannum = Integer.parseInt(br.readLine());
		rec = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean flag = false;
		int count = 0;
		for(int i=0;i<rec;i++) {
			int itemp = Integer.parseInt(st.nextToken());
			if(students[itemp].vote == 0) {
				count++;
				if(flag) {
					int min= Integer.MAX_VALUE;
					int last = Integer.MAX_VALUE;
					int index = 0;
					for(int j=0;j<101;j++) {
						if(students[j].vote < min  && students[j].vote > 0) {
							
							min = students[j].vote;
							last = students[j].date;
							index = j;
						}
						if(students[j].vote == min&& students[j].date < last) {
							min = students[j].vote;
							last = students[j].date;
							index = j;
						}
					}
					students[index].vote = 0;
				}
				
				students[itemp].vote = 1;
				students[itemp].date = i;
				if(count == cannum) {
					flag = true;
				}
			}else {
				students[itemp].vote++;
				
			}
//			for(int k=0;k<100;k++) {
//				if(students[k].vote != 0) {
//					System.out.print(k + " : " + students[k].vote + "\t");
//					System.out.print(i + " : "  + students[i].vote + " ");
//				}
//			}
//			System.out.println();
		}
		for(int i=0;i<100;i++) {
			if(students[i].vote != 0) {
				System.out.print(i + " ");
//				System.out.print(i + " : "  + student[i] + " ");
			}
		}
		
	}

}
