import java.util.Arrays;
import java.util.Scanner;

/*
백준 : 1713 후보 추천하기 실2
1. 사진틀이 비었다면
1-1. 사진이 게시되어있다면 추천++
1-2. 게시 안되있으면 게시해

2. 사진틀이 꽉찼음
2-1. 사진이 게시되어있다면 추천++
2-2. 게시 안되어있으면 젤오래된애 떼고 게시해
 */
public class BOJ_1713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//사진틀의 개수
        int M = sc.nextInt();//전체 학생의 총 추천 횟수

        int[] student = new int[N];//학생 번호
        int[] recommend = new int[N];//추천수 카운트
        int[] order = new int[N];//추천받은 순서

        int tmp=0;
        int idx=0;//사진틀 위치
        for (int i = 0; i < M; i++) {
            tmp = sc.nextInt();//추천학생 번호
            idx =0;
            //사진틀 갯수만큼 반복
            for (int j = 0; j < N; j++) {
                //사진틀이 비어있거나 이미 게시된 경우
                if(student[j]==0||student[j]==tmp){
                    idx=j;//현재인덱스가 사진틀의 인덱스
                    break;
                }
                //사진틀이 비어있지않을때
                //추천횟수가 적거나, 추천횟수가 같으면 게시된지 오래된 사진 삭제
                if(recommend[idx]>recommend[j]||(recommend[idx]==recommend[j]&&order[idx]>order[j])){
                    idx=j;//현재인덱스가 사진틀의 인덱스
                }
            }
            // 사진틀에 게시
            if(student[idx]!=tmp){
                student[idx]=tmp;
                recommend[idx]=0;
                order[idx]=i;
            }
            recommend[idx]++;//추천수 ++
        }
        Arrays.sort(student);


        for (int j = 0; j < student.length; j++) {
            //사진틀이 비어있을수도 있으니까
            if(student[j]!=0) System.out.print(student[j]+" ");
        }
    }
}
