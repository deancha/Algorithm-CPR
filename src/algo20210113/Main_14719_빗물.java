package algo20210113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
	static int H;// 높이
	static int W;// 가로
	static int rain[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		rain = new int[W];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < W; i++) {
			rain[i] = Integer.parseInt(st.nextToken());
		}

		int si = 0;
		int ei = 1;
		int sum = 0;
		int curMax =rain[si];
		int curMin =rain[si];
		while (ei < W) {
			curMin = Math.min(curMin, rain[ei]);
			if (curMax > rain[ei] || curMin >= rain[ei]) {
				ei++;
			} else {
				int cur = rain[si] >= rain[ei] ? rain[ei] : rain[si];
				for (int i = si + 1; i < ei; i++) {
					sum += cur - rain[i];
				}
				si = ei;
				ei++;
				curMax = rain[si];
				curMin =rain[si];
			}
		}
		System.out.println(sum);
	}

}
