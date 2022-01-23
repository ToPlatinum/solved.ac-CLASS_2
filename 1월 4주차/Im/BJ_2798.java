package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798 {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] cards = new int[N];
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }
    L: for (int target = M; target > 1; target--) {
      for (int i = 0; i < cards.length; i++) {
        for (int j = i + 1; j < cards.length; j++) {
          for (int k = j + 1; k < cards.length; k++) {
            if (cards[i] + cards[j] + cards[k] == target) {
              System.out.println(target);
              break L;
            }
          }
        }
      }
    }


  }

}
