package programmers;

import java.util.Arrays;

public class Pro양궁대회 {
	static int max = 1;
	static int [] answer = null;
	public int[] solution(int n, int[] info) {
		per(n,info,0,new int [11],0);
		return answer==null?new int[]{-1}:answer;
		
	}

	private void per(int n, int[] info,int cnt,int [] sel,int start) {
		if(cnt == n) {
			int diff = win(n,info,sel);
			if(diff > max) {
				max = diff;
				int [] arrtemp;
				arrtemp = Arrays.copyOf(sel, sel.length);
				answer = arrtemp;
			}else if(diff==max) {
				compare(sel);
			}
			return;
		}
		for(int i=start;i<11;i++) {
			sel[i]++;
			per(n,info,cnt+1,sel,i);
			sel[i]--;
		}
		
		
	}

	private int win(int n, int[] info, int[] sel) {
		int lion = 0,apich = 0;
		for(int i=0;i<10;i++) {
			if(info[i] == 0 && sel[i] == 0) {
				continue;
			}
			if(info[i] >= sel[i]) {
				apich+=(10 - i);
			}else {
				lion+=(10 - i);
			}
		}
		return lion-apich;
	}

	private void compare(int[] temp) {
		int[] ctemp = new int [11];
		ctemp = Arrays.copyOf(temp, temp.length);
		if(answer == null) {
			answer = ctemp;
		}
		for(int i = 10;i>=0; i--) {
			if(ctemp[i] > answer[i]) {
				answer = ctemp;
				return;
			}
			if(ctemp[i] < answer[i]) {
				return;
			}
		}
		
	}
}
