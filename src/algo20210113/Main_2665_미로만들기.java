package algo20210113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main_2665_미로만들기 {
	static int n;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
			Arrays.fill(visited[i], 100000);
		}

		bfs(0, 0);
		System.out.println(visited[n - 1][n - 1]);
	}

	private static void bfs(int r, int c) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { r, c });
		visited[r][c] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dir[d][0];
				int nc = cur[1] + dir[d][1];

				if (nr >= 0 && nr < n && nc >= 0 && nc < n && visited[nr][nc] > visited[cur[0]][cur[1]]) {
					queue.add(new int[] { nr, nc });
					visited[nr][nc] = visited[cur[0]][cur[1]];
					if (map[nr][nc] == 0) {
						visited[nr][nc] +=1;
					}
				}
			}
		}
	}

}
