package algo20210120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {
	static int N;
	static int[][] map;
	static int[][] visited;
	static int K;
	static Queue<int[]> queue;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(in.readLine());
		K = 1;
		map = new int[N][N];
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					Arrays.fill(visited[k], -1);
				}
				bfs(i, j);
				findMax();
			}
		}
		System.out.println(K);
	}

	private static void findMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(K<visited[i][j]) {
					K= visited[i][j];
				}
			}
		}
	}

	private static void bfs(int r, int c) {
		queue = new LinkedList<int[]>();
		queue.offer(new int[] {r,c,1});
		visited[r][c]=1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			int curK = cur[2];
			for (int d = 0; d < 4; d++) {
				int nr = curR + dir[d][0];
				int nc = curC + dir[d][1];
				if(isIn(nr,nc) && visited[nr][nc] == -1 && map[nr][nc]>map[curR][curC]) {
					visited[nr][nc] = curK+1;
					queue.offer(new int[] {nr,nc,curK+1});
				}
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
