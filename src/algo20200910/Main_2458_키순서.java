package algo20200910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main_2458_키순서 {
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k==i) continue;
				for (int j = 0; j < N; j++) {
					if(k==j || i == j) continue;
					if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE
							&& map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}			
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				if(map[i][j] == Integer.MAX_VALUE && map[j][i]==Integer.MAX_VALUE) {
					flag=false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
