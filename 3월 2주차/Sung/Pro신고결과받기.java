import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int [] answer = new int [id_list.length];
		int [] count = new int [id_list.length];
		int [][] map = new int[id_list.length][id_list.length];
		StringTokenizer st;
		for(int i=0;i<report.length;i++) {
			st = new StringTokenizer(report[i]);
			String from = st.nextToken();
			String to = st.nextToken();
			int fint = 0;
			int tint = 0;
			for(int j=0;j<id_list.length;j++) {
				if(from.equals(id_list[j])) {
					fint = j;
				}
				if(to.equals(id_list[j])) {
					tint = j;
				}
			}
			if(map[fint][tint] == 0) {
				count[tint]++;
				map[fint][tint] = 1;
			}
			
		}
		for(int i=0;i<id_list.length;i++) {
			if(count[i] >=k) {
				for(int j=0;j<map.length;j++) {
					if(map[j][i] == 1) {
						answer[j]++;
					}
				}
			}
		}
        
        
        return answer;
        
    }
}