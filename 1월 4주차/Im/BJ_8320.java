package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8320 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int result = 0;
    for (int a = 1; a <= N; a++) {
      for (int b = 1; b <= a; b++) {
        if (a * b <= N)
          result++;

      }

    }
    System.out.println(result);



  }

}
