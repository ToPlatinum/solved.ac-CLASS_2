import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Swea1234 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n;
        char[] arr;
        Stack<Character> stack;
        for (int i = 1; i <= 10; i++) {
            stack = new Stack<>();
            n = sc.nextInt();
            arr = sc.next().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(arr[j]);
                } else if (stack.peek() == arr[j]) {
                    stack.pop();
                } else {
                    stack.push(arr[j]);
                }
            }
            String result = "";
            for (int j = 0; j < stack.size(); j++) result += stack.get(j);
            System.out.printf("#%d %s%n", i, result);
        }
    }
}
