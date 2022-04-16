package April.week2;

import java.io.*;
import java.util.Stack;

public class BOJ9935 {
    static Stack<Character> stack;
    static int length;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();
        stack = new Stack<>();
        length = target.length();
        boolean isExist;
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= length) {
                isExist = true;
                for (int j = 0; j < length; j++) {
                    if (stack.get(stack.size() - length + j) != target.charAt(j)) {
                        isExist = false;
                        break;
                    }
                }
                if (isExist){
                    stackPop();
                }
            }
        }
        printResult();
    }

    private static void stackPop() {
        for (int i = 0; i < length; i++) {
            stack.pop();
        }
    }

    private static void printResult(){
        sb = new StringBuilder();
        if(stack.size() == 0){
            sb.append("FRULA");
        }else{
            for(int i=0; i<stack.size(); i++){
                sb.append(stack.get(i));
            }
        }
        System.out.println(sb);
    }
}
