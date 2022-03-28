package com.ssafy.study.question.march;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PRO신고결과받기_hash {

	public static void main(String[] args) {
		//입력값
		/*
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        */
        
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        
        
        //report에서 "muzi frodo"-> 앞 : 신고한 id, 뒤: 신고 당한 id
        //한 유저가 같은 유저를 여러 번 신고하는 경우는 1번으로 -> 중복 x
        //k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
        //결과 값
        int[] answer = new int[id_list.length]; //해당 아이디가 신고당해 메일을 받게 된 횟수 출력
        
        //key를 신고한 value
        Map<String, HashSet<String>> map = new HashMap<>();//해당 유저를 신고한 id Set 저장
        Map<String, Integer> index = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
			String name = id_list[i];
			map.put(name, new HashSet<>());
			index.put(name, i);
		}
        
        for (String s : report) {
			String[] str = s.split(" ");
			String from = str[0]; //신고한 id
			String to = str[1]; //신고 당한 id
			map.get(to).add(from);
		}
        
        for (int i = 0; i < id_list.length; i++) {
			HashSet<String> send = map.get(id_list[i]); // 신고당한 id 넣어
			if(send.size() >= k) { //k번 이상 신고당한 거 찾아
				for (String name : send) { 
					//신고한 
					answer[index.get(name)]++;
				}
			}
		}
        for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
        //return answer;
	}

}
