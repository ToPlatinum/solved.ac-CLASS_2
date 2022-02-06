package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17413 {
  public static String reverseprint(String input) {
    char[] temp = input.toCharArray();
    String output = "";
    for (int i = temp.length - 1; i >= 0; i--) {
      output += temp[i];

    }
    return output;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int start = 0;
    int point = 0;
    String temp = "";
    String result = "";
    while (point < input.length()) {
      // 꺽쇠를 만난 경우
      if (input.charAt(point) == '<') {
        result += reverseprint(temp);
        temp ="";
        start = point;
        while (input.charAt(point) != '>') {
          point++;
        }
        result += input.substring(start,point+1);
        point++;
      } else if (input.charAt(point) == ' ') {
        result += reverseprint(temp) + " ";
        // System.out.print(reverseprint(temp) + " ");
        temp = "";
        point++;
      } else if (point >= input.length() - 1) {
        temp += input.charAt(input.length() - 1);
        result += reverseprint(temp);
        break;
      } else {
        temp += input.substring(point, point + 1);
        point++;
      }


    } // while (point < input.length())

    System.out.println(result);

  }
}
