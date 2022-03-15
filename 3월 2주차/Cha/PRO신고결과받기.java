/*
프로그래머스 2022 KAKAO BLIND RECRUITMENT
신고 결과 받기

커밋 메세지 = 프로그래머스 : 신고결과받기
 */
public class PRO신고결과받기 {
    public static void main(String[] args) {
        //입력값 예시
        String[] id_list ={"muzi", "frodo", "apeach", "neo"};
        String[] report ={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k =2;

        //solution
        //신고한 사람, 신고당한사람 저장, 중복 신고 불가능하니까 boolean으로 했다
        boolean[][] singo = new boolean[id_list.length][id_list.length];
        int[] cnt = new int[id_list.length];//신고당한 횟수 세
        int[] answer = new int[id_list.length];//정답 저장 배열 생성
        
        // 신고한애[0] 신고당한애[1]
        for (int i = 0; i < report.length; i++) {
            int user = findUseridx(id_list, report[i].split(" ")[0]);//신고한애
            int bad =findUseridx(id_list, report[i].split(" ")[1]);//신고당한애

            singo[user][bad] = true;
        }
        
        //신고당한 횟수 카운트
        for (int i = 0; i < id_list.length; i++) {
            for (int j = 0; j < id_list.length; j++) {
                if(singo[i][j]==true){
                    cnt[j]++;//신고당한애 인덱스에 저장
                }
            }
        }

        System.out.print("신고 당한 횟수: "+" ");
        for (int i = 0; i < cnt.length; i++) {
            System.out.print(cnt[i]+" ");
        }
        System.out.println();


        //k번이상 신고당한애를 신고한애의 idx를 찾아서 카운트
        for (int i = 0; i < id_list.length; i++) {
            //k번이상 신고당한애를
            if(cnt[i]>=k){
                //신고한애의 idx = j
                for (int j = 0; j < id_list.length; j++) {
                    //신고한애의 idx위치에 answer++해준다
                    if(singo[j][i]==true) answer[j]++;
                }
            }
        }

//        return answer;
        System.out.print("답: "+" ");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
    
    //user의 인덱스를 찾는 함수
    private static int findUseridx(String[] id_list, String name) {
        for(int i=0; i<id_list.length; i++)
        {
            if(id_list[i].equals(name))
                return i;
        } return -1;

    }
}
