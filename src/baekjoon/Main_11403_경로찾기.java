package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1<= N<= 100
public class Main_11403_경로찾기 {
	static int N;
	static int[][] map;
	static int[][] result;
	static boolean[] visited; // 방문체크

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		result = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끄읏

		// 이제 dfs 돌려야 하는데
		// 1. 요건 방향 그래프임!
		// 2. 다 가봐야함
		// 3. 출력 그래프를 0으로 세팅해 놓고 시작하는게 좋을 듯?
		for (int i = 0; i < N; i++) {
			dfs(i, i);
		}

		// 여기부터 출력 부분
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void dfs(int cur, int init) {
		for (int i = 0; i < N; i++) {
			if (map[cur][i] == 1 && result[init][i] != 1) {
				result[init][i] = 1;
				dfs(i, init);
			}
		}
	}


}
