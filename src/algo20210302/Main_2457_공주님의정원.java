package algo20210302;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2457_공주님의정원 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		List<Flower> flowers = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			flowers.add(new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay));
		}

		Collections.sort(flowers);
		int ans = 0;
		// 꽃의 개수를 최소로?
		int max = 0;
		int temp = 301;
		int idx = 0;

		while (temp <= 1130) {
			max = 0;
			

			boolean flag = false;

			for (int i = idx; i < N; i++) {
				Flower cur = flowers.get(i);
				if (cur.start > temp) {
					break;
				}
				if (cur.start <= temp && max < cur.end) {
					max = cur.end;
					idx = i + 1;
					flag = true;
				}
			}
			if (flag) {
				temp = max;
				ans++;
			} else {
				break;
			}

		}

		if (max <= 1130) {
			ans = 0;
		}
		System.out.println(ans);

	}

	static class Flower implements Comparable<Flower> {
		int start;
		int end;

		public Flower(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower o) {
			if (this.start == o.start) {
				return Integer.compare(this.end, o.end);
			} else {
				return Integer.compare(this.start, o.start);
			}

		}

	}
}
