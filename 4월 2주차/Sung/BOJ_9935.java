package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
	static String base;
	static String bom;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		base = br.readLine();
		bom = br.readLine();

		String result = sol();
		System.out.println(result.equals("") ? "FRULA" : result);
	}

	private static String sol() {
		boolean flag;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		Stack<Character> substack = new Stack<>();
		
		for (int i = 0; i < base.length(); i++) {
			if (base.charAt(i) == bom.charAt(bom.length() - 1)) {
				substack = new Stack<Character>();
				substack.add(base.charAt(i));
				flag = true;
				for (int j = 0; j < bom.length() - 1; j++) {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					char c = stack.pop();
					
					substack.add(c);
					if (c != bom.charAt(bom.length() - j - 2)) {
						flag = false;
						break;
					}
				}
				if (!flag) {
					while(!substack.isEmpty()) {
						stack.add(substack.pop());
					}
				}
			} else {
				stack.add(base.charAt(i));
			}

		}
		substack = new Stack<Character>();
		while(!stack.isEmpty()) {
			substack.add(stack.pop());
		}
		while(!substack.isEmpty()) {
			sb.append(substack.pop());
		}
		return sb.toString();
	}

}
