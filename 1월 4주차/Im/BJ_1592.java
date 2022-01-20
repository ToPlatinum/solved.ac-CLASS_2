package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592 {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    /*
     * N : 사람들이 원형테이블의 1~N까지 시계방향으로 앉는다. M : 한사람이 공을 M번 받으면 끝난다.(지금 받은 공도 포함하여 카운트) L : 공을 받은 사람의 받은
     * 횟수가 홀수면 시계방향으로 L번째의 사람에게, 짝수이면 반시계방향으로 L번째사람에게 던진다.
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    int[] table = new int[N];
    int current = 0;// 현재위치
    int totalcnt = 0;// 공을 받은 횟수

    while (true) {
      table[current]++;// 공은 모든 과정의 첫번째에 받는다
      if (table[current] == M) {// 현재 공을 받은 횟수가 M이라면
        System.out.println(totalcnt);// 현재까지 공을 던진 횟수를 출력해주고
        break;// 과정을 끝낸다.
      } else if (table[current] % 2 == 1) {// 만약 공을 받은 횟수가 M이 아니고 현재 공을 받은 횟수가 홀수라면
        current = (current + L) % N;// 현재위치에서 L만큼을 더하고 범위안에 위치시키기위해 %N을 해준다.
      } else {// 만약 공을 받은 횟수가 M이 아니고 현재 공을 받은 횟수가 짝수라면
        current = (current + (N - L)) % N;// 범위 안에 위치시키기위해 (N-L)과정을 거쳐 %N을 해준다.
      }
      totalcnt++;// 공은 모든 과정의 마지막에 던진다.
    }
  }
}
