package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 문제 정리 
 * 연구소 크기 N x M
 * 
 * 칸의 정보는 3가지
 * 0 : 빈 칸
 * 1 : 벽
 * 2 : 바이러스
 * 
 * 바이러스의 개수 x : 2<=x<=10
 * 빈칸의 개수는 3개 이상
 * 
 * 벽의 개수는 꼭 3개여야함
 * -> 조합으로 풀어야함 
 * 
 * 
 */
public class Main_14502_연구소 {

	static int N, M, maxSafeZone;
	static int map[][];
	static int temp[][];
	static boolean visitedTemp[][];
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// ============= 입력 =================
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maxSafeZone = 0;

		map = new int[N][M];
		temp = new int[N][M];
		visitedTemp = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// ============= 풀이 =================

		// 일단 조합으로 벽을 만들어줘야 함 ㅇㅋ?

		makeWall(0, 0);
		
		System.out.println(maxSafeZone);
	}

	private static void makeWall(int cur, int cnt) {

		if (cnt == 3) {
			// 벽이 3개가 만들어짐 -> 바이러스 퍼뜨려야 함
			
			// map 에다가 바로 바이러스를 퍼뜨리면 다른 조합이 불가능 하니까
			// 바이러스를 퍼트릴 임시 map을 만듬
			for (int i = 0; i < N; i++) {
				temp[i] = map[i].clone();
				Arrays.fill(visitedTemp[i], false);
			}
			spreadVirus();	//바이러스 퍼뜨리기
			countSafeZone();
			return;
		}

		for (int i = cur; i < N * M; i++) {
			int r = i / M;	//map에서 r
			int c = i % M;	//map에서 c
			if(map[r][c] == 0) {
				map[r][c] = 1;	//벽 만듬 
				makeWall(i+1, cnt+1);//다음 벽세우고 옴
				map[r][c] = 0;	//벽 다시 없애고 진행
			}
		}
	}

	private static void countSafeZone() {
		
		int cnt = 0 ;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j]==0) {
					cnt++;
				}
			}
		}
		
		maxSafeZone = Math.max(maxSafeZone, cnt);
	}

	// 요 메소드는 바이러스를 퍼뜨리는 역할을 함
	// 주의할거! temp 배열에서 해야함 
	private static void spreadVirus() {
		Queue<int []> queue  = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j]==2) {
					visitedTemp[i][j] = true;
					queue.offer(new int[] {i,j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if(isIn(nr,nc) && temp[nr][nc]==0 && !visitedTemp[nr][nc]) {
					visitedTemp[nr][nc] = true;
					temp[nr][nc] = 2;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
