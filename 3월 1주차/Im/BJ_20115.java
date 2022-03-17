package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20115 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		double max = Double.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		double result = max;
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));		
		for (int i = 0; i < arr.length - 1; i++) {
			if (max != arr[i])
				result += arr[i] / 2;
		}
		System.out.println(result);
	}

}
