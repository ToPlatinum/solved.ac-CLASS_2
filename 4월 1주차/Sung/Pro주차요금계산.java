package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Pro주차요금계산 {
	static class Carinfo{
		int id, total;
		
	}
	static class History implements Comparable<History>{
		int hour,min,id;
		boolean inout;
		
		@Override
		public String toString() {
			return "History [hour=" + hour + ", min=" + min + ", id=" + id + ", inout=" + inout + "]";
		}
		
		public History(int hour, int min, int id, boolean inout) {
			super();
			this.hour = hour;
			this.min = min;
			this.id = id;
			this.inout = inout;
		}
		
		// PriorityQueue를 사용할 예정이므로 compareable을 implements하고 함수를 오버라이딩합니다.
		@Override
		public int compareTo(History o) {
			// TODO Auto-generated method stub
			return this.id == o.id? this.hour == o.hour ?this.min - o.min: this.hour - o.hour : this.id-o.id;
		}
		
		
	}
	
	public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        StringTokenizer st;
        PriorityQueue<History> PQ = new PriorityQueue<>();
        // 받아온 데이터를 PQ에 넣기위해 위에서 만들어 놓은 객체로 바꾸어주고 PQ에 넣어줍니다.
        for(int i=0;i<records.length;i++) {
        	st = new StringTokenizer(records[i],": ");
        	History temph = new History(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), st.nextToken().equals("IN")? true: false);
        	PQ.add(temph);
        }
        // 차의 번호와 주차했던 총 시간을 저장할 배열입니다.
        ArrayList<Carinfo> AL = new ArrayList<>();

        while(!PQ.isEmpty()) {
        	History h = PQ.poll();
        	// System.out.println(h);
        	Carinfo tci = new Carinfo();
        	// 차가 2번이상 왔다갔다 할경우입니다.
        	if(AL.size()!= 0 && h.id == AL.get(AL.size()-1).id) {
        		//해당차량의 정보를 꺼낸 후 배열에서 제거합니다.(이후에 다시 넣어줍니다.)
        		tci = AL.get(AL.size()-1);
        		AL.remove(AL.size()-1);	

        	}else {	// 차가 처음 왔을때입니다.(한번만 왔다갔다는 건 아닙니다)
        		tci.id = h.id;
        	}
        	//만약에 출차기록이 없다면 23:59분에 출차한 것으로 취급합니다.
        	if(PQ.isEmpty() || PQ.peek().id != h.id) {
        		tci.total += 60*(23 - h.hour) + (59 - h.min);
        		AL.add(tci);
        		continue;
        	}
        	// 출차 정보입니다.
        	History hout = PQ.poll();
        	// System.out.println(hout);
        	// 출차 시간과 입차 시간을 비교하여 시간을 계산하여 더해준 후 배열에 저장합니다.
        	tci.total += 60*(hout.hour - h.hour) + (hout.min - h.min);
        	AL.add(tci);
        }
        answer = new int [AL.size()];
        for(int i=0;i<answer.length;i++) {
        	// 시간을 통해 가격을 계산해줍니다.
        	answer[i] = AL.get(i).total > fees[0] ?  (int)Math.ceil(((double)AL.get(i).total - fees[0])/fees[2]) * fees[3] + fees[1]: fees[1];
        }
        
        
        return answer;
    }
}
