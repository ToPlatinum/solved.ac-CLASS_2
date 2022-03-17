package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1713 {
	static class picture {
		int stuNum;
		int recCnt;
		int period;

		public picture(int stuNum, int recCnt, int period) {
			this.stuNum = stuNum;
			this.recCnt = recCnt;
			this.period = period;
		}
	}

	static ArrayList<picture> picList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫째 줄에는 사진틀의 개수 N이 주어진다. (1 ≤ N ≤ 20)
		int N = Integer.parseInt(br.readLine());
		// 둘째 줄에는 전체 학생의 총 추천 횟수가 주어지고,
		int totalRek = Integer.parseInt(br.readLine());
		// 셋째 줄에는 추천받은 학생을 나타내는 번호가 빈 칸을 사이에 두고 추천받은 순서대로 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] rekArr = new int[totalRek];
		for (int i = 0; i < rekArr.length; i++) {
			rekArr[i] = Integer.parseInt(st.nextToken());
		}

		// 사진틀 리스트
		picList = new ArrayList<picture>();
		// 본격적인 코드 시작
		for (int i = 0; i < rekArr.length; i++) {
//			System.out.println("작업시작");
//			for(picture p : picList) {
//				System.out.print(p.stuNum+" ");
//			}
//			System.out.println();
			// 추천하기
			// 추천할 학생 번호
			int rekNum = rekArr[i];
			// 조건1 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고,
			// 그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
			// 이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는
			// 그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
			// 사진틀에 등록된 사용자라면 추천횟수만 증가시켜준다
//			System.out.println("이번 추천할 학생 번호는 : "+rekNum);
			if (isPicListIn(rekNum) == true) {
//				System.out.println("이미 있는 이용자 "+rekNum);
				for (int n = 0; n < picList.size(); n++) {
					if (picList.get(n).stuNum == rekNum) {
						picList.get(n).recCnt++;
						break;
					}
				}
			}
			// 만약 사진틀이 꽉 찼다면
			else if (picList.size() == N) {
//				System.out.println("사진틀 꽉참");
				ArrayList<picture> tempPicList = new ArrayList<picture>();
				// 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상인지 체크
				int minRek = minRekCheck();
				int cnt = 0;

				for (int n = 0; n < picList.size(); n++) {
					if (picList.get(n).recCnt == minRek) {
						tempPicList.add(picList.get(n));
					}
				}
				
				// 두 명 이상일 경우에는 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
				if (tempPicList.size() > 1) {
//					System.out.println("두명이상");
					int minPeriod = oldPeriodCheck(tempPicList);
					for (int j = 0; j < tempPicList.size(); j++) {
						if (tempPicList.get(j).period == minPeriod) {
							for (int k = 0; k < picList.size(); k++) {
								if (picList.get(k).equals(tempPicList.get(j))) {
									picList.remove(k);
									picList.add(new picture(rekNum, 1, i));
									break;
								}
							}
						}
					}
				}
				// 한명일 경우에 그 학생 삭제
				else {
//					System.out.println("한명");
//					for(picture p : tempPicList) {
//						System.out.print(p.stuNum+" ");
//					}
					for (int j = 0; j < tempPicList.size(); j++) {
						for (int k = 0; k < picList.size(); k++) {
							if (picList.get(k).equals(tempPicList.get(j))) {
								picList.remove(k);
								picList.add(new picture(rekNum, 1, i));
								break;
							}
						}
					}
				}
			}
			// 사진틀에 등록되지 않은 학생이라면 등록해준다
			else if (isPicListIn(rekNum) == false) {
				picList.add(new picture(rekNum, 1, i));
			}
//			System.out.println("사진틀작업 결과");
//			for(picture p : picList) {
//				System.out.print(p.stuNum+" ");
//			}
//			System.out.println();
//			System.out.println();
		}
//		결과 출력을 위한 정렬
		int[] result = new int[picList.size()];
		for (int j = 0; j < picList.size(); j++) {
			result[j] = picList.get(j).stuNum;
		}
		Arrays.sort(result);
		for(int a : result) {
			System.out.print(a+" ");
		}
	}

	static int oldPeriodCheck(ArrayList<picture> tempPicList) {
		int min = Integer.MAX_VALUE;
		for (int n = 0; n < tempPicList.size(); n++) {
			if (tempPicList.get(n).period < min) {
				min = tempPicList.get(n).period;
			}
		}
		return min;
	}

	static int minRekCheck() {
		int min = Integer.MAX_VALUE;
		for (int n = 0; n < picList.size(); n++) {
			if (picList.get(n).recCnt < min) {
				min = picList.get(n).recCnt;
			}
		}
		return min;
	}

	static boolean isPicListIn(int stuNum) {
		for (int n = 0; n < picList.size(); n++) {
			if (picList.get(n).stuNum == stuNum)
//				System.out.println("___같음___");
				return true;
		}

		return false;
	}

}
