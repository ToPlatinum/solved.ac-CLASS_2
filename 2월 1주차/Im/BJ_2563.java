package bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563 {
  public static void printarr() {
    for (int[] a : table) {
      for (int b : a) {
        System.out.print(b + " ");
      }
      System.out.println();
    }
  }

  public static void putpaper(int a, int b) {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (table[a + i][b + j] == 0) {
          table[a + i][b + j] = 1;
        }
      }
    }
  }

  public static int count() {
    int result = 0;
    for (int i = 0; i < table.length; i++) {
      for (int j = 0; j < table.length; j++) {
        if (table[i][j] == 1)
          result++;
      }

    }
    return result;
  }

  static int[][] table = new int[100][100];

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      putpaper(a, b);
    }
    // printarr();
    System.out.println(count());


  }

}
