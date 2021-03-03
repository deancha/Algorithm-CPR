package algo20200910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_2660_회장뽑기 {
	static int N;
	static int[][] map;
	static final int maxV = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], maxV);
		}

		while (true) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) -1;
			int b = Integer.parseInt(st.nextToken()) -1 ;

			if (a == -2 && b == -2)
				break;
			
			map[a][b] = map[b][a] = 1;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k==i) continue;
				for (int j = 0; j < N; j++) {
					if(k==j || i==j) continue;
					if(map[i][k] != maxV && map[k][j] !=maxV
							&& map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int score = N;
		
		Set<Integer> set = new TreeSet<>();
		
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				max = Math.max(max, map[i][j]);
			}
			
			if(max < score) {
				set.clear();
				set.add(i);
				score = Math.min(max, score);
			}
			
			if(max == score) {
				set.add(i);
			}
		}
		
		System.out.println(score + " " + set.size());
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print((iter.next()+1)+" ");
		}
		
		
	}

}
