package bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2999 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String temp = br.readLine();
    // String temp = "boudonuimilcbsai";
    int N = temp.length();
    int R = 0;
    int C = 0;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i > j) // R<=C -> i<=j이기때문에 이 반대의 경우에는 그냥 패스하도록한다.
          continue;
        else {
          if (i * j == N) {
//            System.out.println("R=" + i + " C=" + j);
            if (R < i) {
              R = i;
              C = j;
            }
          }
        }
      }
    }
//    System.out.println("R=" + R + " C=" + C);
    // 여기서부터 배열 생성 시작
    int cnt = 0;
    char[][] table = new char[R][C];
    for (int i = 0; i < C; i++) {
      for (int j = 0; j < R; j++) {
        table[j][i] = temp.charAt(cnt++);
      }
    }

//    for (char[] a : table) {
//      for (char b : a) {
//        System.out.print(b + " ");
//      }
//      System.out.println();
//    }

    // 여기서부터 탐색 시작
    String result = "";
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        result += table[i][j];

      }
    }
    System.out.println(result);
  }
}

