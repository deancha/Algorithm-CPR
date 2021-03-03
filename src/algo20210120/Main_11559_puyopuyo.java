package algo20210120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11559_puyopuyo {
	static final int R = 12;
	static final int C = 6;
	static char map[][];
	static boolean visited[][];
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int checkV;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		// 1) 중력의 영향을 받아 아래로 떨어짐
		// 2) 상하좌우에 같은색이 4개 이상 연결되어있다면 한번에 없어짐 -> dfs로 체크
		// 3) 터지고 나서 위에 뿌요들이 있으면 다시 떨어짐
		// 4) 떨어지고 터지는 걸 반복할 때 +1 연쇄
		// 5) 동시에 터져야하고, 여러그룹이 터지더라도 +1만 셈!!

		int answer = 0;
		while (true) {
			// 터질 수 있는지 체크
			if (isP()) {
				// 동시에 터트림
				bomb();
				// 아래로 내려옴
				gravity();
				// 연쇄 +1
				answer++;
			} else {
				// 안되면 break
				break;
			}
		}

		System.out.println(answer);

	}

	private static void bomb() {
		// TODO Auto-generated method stub

	}

	private static void gravity() {
		for (int c = 0; c < C; c++) {
			for (int r = R - 2; r >= 0; r--) {
				if (map[r][c] != '.') {
					char temp = map[r][c];
					for (int i = r + 1; i < R; i++) {
						if (map[i][c] == '.') {
							map[i][c] = temp;
							map[i - 1][c] = '.';
						}
					}
				}
			}
		}
	}

	private static boolean isP() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != '.' && !visited[r][c]) {
					visited[r][c] = true;
					checkV = 0;
				}
			}
		}
		return false;
	}

	private static int dfs(int r, int c, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
				
			}
		}
	}

}
