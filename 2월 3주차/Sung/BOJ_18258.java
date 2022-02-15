package week2_3.baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class tempq {
	int[] intarr;
	int end;
	int start;
	int maxsize;
	private static tempq instance;

	private tempq() {
		maxsize = 2000000;
		end = -1;
		start = 0;
		intarr = new int[maxsize];
	}

	public static tempq getInstance() {
		if (instance == null) {
			instance = new tempq();
		}
		return instance;
	}

	public void push(int data) {

		intarr[++end] = data;

	}

	public int front() {
		if (empty() == 1) {
			return -1;
		}
		return intarr[start];
	}

	public int back() {
		if (empty() == 1) {
			return -1;
		}
		return intarr[end];
	}

	public int size() {
		return end - start + 1;
	}

	public int empty() {
		if (end - start == -1)
			return 1;
		return 0;
	}

	public int pop() {
		if (empty() == 1)
			return -1;
		int itemp = intarr[start++];
		return itemp;
	}
}

public class BOJ_18258 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int orders = Integer.parseInt(br.readLine());
		String order;
		int recnum;
		tempq ins = tempq.getInstance();
		String str;
		StringTokenizer st;
		for (int i = 0; i < orders; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			order = st.nextToken();
			if (order.equals("push")) {
				recnum = Integer.parseInt(st.nextToken());
				ins.push(recnum);

			} else if (order.equals("front")) {
				bw.write(ins.front() + "\n");
			} else if (order.equals("back")) {
				bw.write(ins.back() + "\n");
			} else if (order.equals("size")) {
				bw.write(ins.size() + "\n");
			} else if (order.equals("empty")) {
				bw.write(ins.empty() + "\n");
			} else if (order.equals("pop")) {
				bw.write(ins.pop() + "\n");
			}

		}
		bw.flush();

	}

}