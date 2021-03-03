package algo20200919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int N;
	static int M;
	static char[][] board;

	static int redR;
	static int redC;
	static int blueR;
	static int blueC;
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
				if(board[i][j] == 'R') {
					redR = i;
					redC = j;
				}
				if(board[i][j] == 'B') {
					blueR = i;
					blueC = j;
				}
			}
		}
	}

}
