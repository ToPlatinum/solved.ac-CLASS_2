import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
    static int N;//수빈
    static int K;//동생
    static int[] v = new int[100001];//방문 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        //수빈이랑 동생이랑 이미 만났움
        if (N == K) {
            System.out.println(0);
        }
        //아니면 bfs에 들으가
        else{
            bfs(N);//수빈씨 들어가
        }
    }

    static void bfs(int subin) {
        Queue<Integer> q = new LinkedList<>();
        q.add(subin);//수빈 넣어
        v[subin] = 1;//현재위치의 시간을 1로 설정

        while (!q.isEmpty()) {
            int temp = q.poll();//현재위치

            // + - * 를 해조
            for (int i = 0; i < 3; i++) {
                int next;//담에 갈 위치

                //한번씩 다 해보고
                if (i == 0) {
                    next = temp + 1;//앞으로 한칸
                } else if (i == 1) {
                    next = temp - 1;//뒤로 한칸
                } else {
                    next = temp * 2;//순간이동
                }

                //K에 도착하면
                if (next == K) {
                    //현재위치의 시간을 출력하고 종료
                    System.out.println(v[temp]);
                    return;
                }

                //아직동생 못잡앗구
                //범위내에 있으면서 방문하지 않았다면
                if (next >= 0 && next < v.length && v[next] == 0) {
                    q.add(next);//다음위치 넣어
                    v[next] = v[temp] + 1;//전위치시간+1
                }
            }
        }
    }
}
