package 이베이코리아연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1034_램프 {
	
	static int N;	//행
	static int M;	//열
	static int K;	//스위치를 누른 횟수
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		  
		
		
	}
	
	static int countRowLight() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean check = true;
			for (int j = 0; j < M; j++) {
				//켜진 상태가 아니라면 
				if(map[i][j] ==0) {
					check = false;
					break;
				}
			}	
			if(check) {
				cnt++;
			}
		}
		return cnt;
	}
}
