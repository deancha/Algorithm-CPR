package algo20210210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int[][] dir = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 1, 0, 0 }, { -1, 0, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int map[][][] = new int[H][N][M];
		boolean checked[][][] = new boolean[H][N][M];
		LinkedList<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) {
						queue.add(new int[] { i, j, k });
						checked[i][j][k] = true;

					}
					if (map[i][j][k] == -1) {
						checked[i][j][k] = true;
					}
					

				}
			}
		}

		int count = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int[] cur = queue.poll();
				int z = cur[0];
				int r = cur[1];
				int c = cur[2];
				checked[z][r][c] = true;

				for (int d = 0; d < 6; d++) {
					int nz = z + dir[d][0];
					int nr = r + dir[d][1];
					int nc = c + dir[d][2];
					if (nz >= 0 && nr >= 0 && nc >= 0 && nz < H && nr < N && nc < M && !checked[nz][nr][nc]
							&& map[nz][nr][nc] == 0) {
						queue.add(new int[] { nz, nr, nc });
						checked[z][r][c] = true;

					}
				}
			}
			
			count++;
		}
		top:
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (!checked[i][j][k]) {
						count = -1;
						break top;
					}
				}
			}
		}
		System.out.println(count);
		
	}

}
