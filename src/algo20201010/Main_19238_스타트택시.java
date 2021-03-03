package algo20201010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_스타트택시 {
	static int N; // 정방
	static int M; // 승객수
	static int map[][]; // 길
	static int energy;
	static int dir[][] = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static boolean visited[][];
	static int driveR;
	static int driveC;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		energy = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		driveR = Integer.parseInt(st.nextToken()) - 1;
		driveC = Integer.parseInt(st.nextToken()) - 1;

		LinkedList<int[]> customer = new LinkedList<>();
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			customer.add(new int[] { a, b, c, d });
		}

		top1: while (true) {
			queue.add(new int[] { driveR, driveC, 0 });
			visited[driveR][driveC] = true;

			top2: while (!queue.isEmpty()) {
				int cur[] = queue.poll();
				int r = cur[0];
				int c = cur[1];
				int cnt = cur[2];

				if (energy - cnt == 0) {
					System.out.println(-1);
					break top1;
				}

				for (int i = 0; i < M; i++) {
					int[] cus = customer.get(i);
					if (r == cus[0] && c == cus[1]) {
						customer.remove(i);
						for (int j = 0; j < N; j++) {
							Arrays.fill(visited[j], false);
						}
						energy -= cnt;
						driveR = r;
						driveC = c;
						bfs(cus[2], cus[3]);
						break top2;
					}
				}

				for (int d = 0; d < 4; d++) {
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];
					if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] != 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc, cnt + 1 });
					}
				}
			}

		}

	}

	private static void bfs(int targetR, int targetC) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { driveR, driveC, 0 });
		visited[driveR][driveC] = true;

		while (!que.isEmpty()) {
			int cur[] = que.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];

			if (energy - cnt == 0) {
				System.out.println(-1);
				break;
			}

			if (r == targetR && c == targetC) {
				for (int j = 0; j < N; j++) {
					Arrays.fill(visited[j], false);
				}
				energy -= cnt;
				driveR = r;
				driveC = c;

				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] != 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.add(new int[] { nr, nc, cnt + 1 });
				}
			}
		}
	}

}
