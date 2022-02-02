package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941 {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    String[] cTable = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String temp = br.readLine();
    for (int i = 0; i < cTable.length; i++) {
      if (temp.contains(cTable[i])) {
        temp = temp.replace(cTable[i], "A");
      }
    }
    System.out.println(temp.length());


  }

}
