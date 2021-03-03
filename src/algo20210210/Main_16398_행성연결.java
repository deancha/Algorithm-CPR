package algo20210210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16398_행성연결 {
	static int N;
	static int[] parents;

	static public void makeSet(int v) {
		parents[v] = v;
	}

	static public int findSet(int v) {
		if (parents[v] == v) {
			return v;
		}
		parents[v] = findSet(parents[v]);
		return parents[v];
	}

	static public void union(int v, int u) {
		if(v>u) {
			parents[findSet(v)] = findSet(u);
		}else {
			parents[findSet(u)] = findSet(v);

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		parents=new int [N];
		LinkedList<Star> list = new LinkedList<Star>();
		for (int i = 0; i < N; i++) {
			makeSet(i);
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i == j)
					continue;
				list.add(new Star(i, j, w));
			}
		}
		Collections.sort(list);

		long minSum = 0;
		int count = 0;
		while (!list.isEmpty()) {
			if(count == N-1) {
				break;
			}
			Star star = list.poll();

			if (findSet(star.start) == findSet(star.end)) {
				continue;
			}
			minSum += star.w;
			count++;
			union(star.start, star.end);

		}
		
		System.out.println(minSum);

	}
	

	static class Star implements Comparable<Star> {
		int start;
		int end;
		int w;

		public Star(int start, int end, int w) {
			super();
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Star o) {
			return Integer.compare(this.w, o.w);
		}

	}

}
