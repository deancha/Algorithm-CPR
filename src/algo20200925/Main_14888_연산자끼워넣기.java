package algo20200925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int N;
	static int arr[];
	static int op[];
	static int maxV;
	static int minV;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		maxV = Integer.MIN_VALUE;
		minV = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		op = new int[4];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		permu(1, arr[0]);

		System.out.println(maxV);
		System.out.println(minV);
	}

	private static void permu(int idx, int result) {
		if (idx == N) {
			maxV = Math.max(maxV, result);
			minV = Math.min(minV, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i]--;
				if (i == 0) {
					permu(idx + 1, result + arr[idx]);
				} else if (i == 1) {
					permu(idx + 1, result - arr[idx]);
				} else if (i == 2) {
					permu(idx + 1, result * arr[idx]);
				} else {
					permu(idx + 1, result / arr[idx]);
				}
				op[i]++;
			}
		}

	}

}
