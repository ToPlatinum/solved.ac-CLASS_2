package lv_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PRO신고결과받기 {
	static ArrayList<person> people;

	static class person {
		public person(String name, int report, int mailCnt, ArrayList<String> reported_people) {
			this.name = name;
			this.report = report;
			this.mailCnt = mailCnt;
			this.reported_people = reported_people;
		}

		String name;
		int report;
		int mailCnt;
		// 신고자를 여기 저장해서 중복신고를 방지
		ArrayList<String> reported_people;
	}

	static void checkBlock(person p, int k) {
		if (p.report >= k) {
			for (int i = 0; i < people.size(); i++) {
				if (p.reported_people.contains(people.get(i).name)) {
					people.get(i).mailCnt++;
				}
			}
		}
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		people = new ArrayList<person>();
		// 데이터 추가
		for (int i = 0; i < id_list.length; i++) {
			people.add(new person(id_list[i], 0, 0, new ArrayList<String>()));
		}
		for (int n = 0; n < report.length; n++) {
			String temp = report[n];
			StringTokenizer st = new StringTokenizer(temp);
			String A = st.nextToken();
			String B = st.nextToken();
			for (int i = 0; i < people.size(); i++) {
				if (people.get(i).name.equals(B)) {
					if (!people.get(i).reported_people.contains(A)) {
						people.get(i).report++;
						people.get(i).reported_people.add(A);
//					checkBlock(people.get(i), k);
						break;
					}
				}
			}
		}
		for (int i = 0; i < people.size(); i++) {
			checkBlock(people.get(i), k);
		}
		int cnt = 0;
		for (person p : people) {
			answer[cnt++] = p.mailCnt;
		}

		return answer;
	}

	public static void main(String[] args) {
		// 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다.
		// 무지가 개발하려는 시스템은 다음과 같습니다.
		// 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
		// 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
		// 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
		// k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
		// 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
		String[] id_list1 = { "muzi", "frodo", "apeach", "neo" };
		String[] id_list2 = { "con", "ryan" };

		String[] report1 = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		String[] report2 = { "ryan con", "ryan con", "ryan con", "ryan con" };

		int k1 = 2;
		int k2 = 3;
		System.out.println(Arrays.toString(solution(id_list2, report2, k2)));

	}

}
