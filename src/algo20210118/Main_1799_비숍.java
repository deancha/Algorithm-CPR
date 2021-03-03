package algo20210118;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1799_비숍 {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int dir[][] = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int maxV;
	static boolean isP[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		maxV = -1;
		isP = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(isP[i], true);
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

			// 생각해보자
		}
		dfs(0, 0);
		System.out.println(maxV);
	}

	private static void dfs(int cur, int cnt) {

		for (int i = cur; i < N * N; i++) {
			int r = i / N;
			int c = i % N;
			// 일단 놓을 수 잇는 자리여야 하고 방문 안했어야함
			if (map[r][c] == 1 && !visited[r][c] && isP[r][c]) {
				if (checkVisited(r, c)) {
					changeP(r, c);
					visited[r][c] = true;
					
					maxV = Math.max(maxV, cnt + 1);
					dfs(i + 1, cnt + 1);
					
					visited[r][c] = false;
					changeP(r, c);
				}
			}
		}
	}

	private static void changeP(int r, int c) {

		isP[r][c] = !isP[r][c];
		for (int d = 0; d < 4; d++) {
			int mul = 1;
			while (true) {
				int nr = r + dir[d][0] * mul;
				int nc = c + dir[d][1] * mul;
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					break;
				isP[nr][nc] = !isP[nr][nc];
				mul++;
			}
		}
	}

	

	private static boolean checkVisited(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int mul = 1;
			while (true) {
				int nr = r + dir[d][0] * mul;
				int nc = c + dir[d][1] * mul;
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					break;
				if (visited[nr][nc]) {
					return false;
				}
				mul++;
			}
		}
		return true;
	}

}
