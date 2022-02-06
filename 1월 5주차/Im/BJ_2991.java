package bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_2991 {
  static boolean[] attack1;
  static boolean[] attack2;

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    // StringTokenizer st = new StringTokenizer(br.readLine());
    // int A = Integer.parseInt(st.nextToken());
    // int B = Integer.parseInt(st.nextToken());
    int A = sc.nextInt();
    int B = sc.nextInt();
    attack1 = new boolean[A + B];
    for (int i = 0; i < A; i++) {
      attack1[i] = true;
    }
    // int C = Integer.parseInt(st.nextToken());
    // int D = Integer.parseInt(st.nextToken());
    int C = sc.nextInt();
    int D = sc.nextInt();
    attack2 = new boolean[C + D];
    for (int i = 0; i < C; i++) {
      attack2[i] = true;
    }

    for (int i = 0; i < 3; i++) {// 배달원 3명의 일 반복
      int result = 0;
      int P = sc.nextInt();
      int temp = P % attack1.length;
      if (temp == 0)
        temp = attack1.length - 2;
      else
        temp--;
      if (attack1[temp] == true) {
        result++;
      }

      temp = P % attack2.length;
      if (temp == 0)
        temp = attack2.length - 2;
      else
        temp--;
      if (attack2[temp] == true) {
        result++;
      }
      System.out.println(result);

    }



  }

}
