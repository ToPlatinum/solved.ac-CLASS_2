package level_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1234 {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int testCase = 1; testCase <= 10; testCase++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      String temp = st.nextToken();
      ArrayList<Integer> list = new ArrayList<Integer>();

      for (int i = 0; i < N; i++) {
        list.add(Integer.parseInt(temp.substring(i, i + 1)));
      }

      int cnt = 0;
      while (true) {
        if (cnt == list.size() - 1) {// cnt가 리스트의 가장 마지막위치와 같다면 멈추기
          break;
        }
        if (list.get(cnt).equals(list.get(cnt + 1))) {
          list.remove(cnt);
          list.remove(cnt);
          cnt = 0;// 처음부터 다시 순차탐색하기위함
        } else
          cnt++;// 같지 않으면 다음인자들을 확인하기 위함
      }
      String result = "";
      for (int j = 0; j < list.size(); j++) {
        result += list.get(j) + "";
      }
      System.out.printf("#%d %s\n", testCase, result);
    }
  }
}

