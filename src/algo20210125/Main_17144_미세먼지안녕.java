package algo20210125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int R;
	static int C;
	static int T;
	static int topR;
	static int topC;
	static int botR;
	static int botC;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		topR = -2;
		topC = -2;
		botR = -2;
		botC = -2;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					if (topR == -2) {
						topR = i;
						topC = j;
					} else {
						botR = i;
						botC = j;
					}
				}
			}
		}

		// 1초동안 일어나는 일
		for (int t = 0; t < 5; t++) {
			// 1. 미세먼지가 확산하고 모든 칸에서 동시에 일어난다.
			spreadDust();
			
			// 2. 공기청정기가 작동
//			airCleaner();
		}

		// 미세먼지양 출력
		int ans = AmountDust();
		
		System.out.println(ans);

	}

	private static void airCleaner() {
		
		//맨왼쪽 끝에서 공기청정기까지
		for (int r = topR-1; r >=0; r--) {
			if(r+1 == topR) continue;
			map[r+1][topC] = map[r][topC];
		}
		//맨위 오른쪽 끝에서 왼쪽끝으로
		for (int c = 1; c < C; c++) {
			map[0][c-1] = map[0][c];
			map[0][c]=0;
		}
		//오른쪽 끝에서 위로
		for (int r = 1; r < topR; r++) {
			map[r-1][C-1] = map[r][C-1]; 
			map[r][C-1]=0;
		}
		//오른쪽 끝으로
		for (int c = C-2; c >= topC+1 ; c--) {
			map[topR][c+1] = map[topR][c];
			map[topR][c]=0;
			
		}
		
		
	}

	private static int AmountDust() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}
		return sum;
	}

	private static void spreadDust() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0) {
					if (map[i][j] == -1)
						continue;
					int dCnt = 0;
					
					for (int d = 0; d < 4; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];
						if (isIn(nr, nc) && map[nr][nc] != -1) {
							dCnt++;
						}
					}
					
					int spread = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];
						if (isIn(nr, nc) && map[nr][nc] != -1) {
							map[nr][nc] += spread;
						}
					}
					map[i][j] -= (spread * dCnt);
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
