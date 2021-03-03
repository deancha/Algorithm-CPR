package algo20200903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2665_미로만들기 {
	
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int n;
	static final int maxN = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String line = in.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
				dist[i][j] = maxN;
			}
		}//입력끝
		
		 
		for (int k = 0; k < N; k++) {
			
		}
		
		
	}

}
