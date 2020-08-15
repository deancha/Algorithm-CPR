package algo20200815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//20200815

/*
 * 문제분석
 * 
 * 1<= n <= 100 : 도시
 * 1<= m <= 100,000 : 한도시에서 출발해서 다른 도시에 도착하는 버스의 수
 * 버스의 정보
 *  - a : 시작 도시
 *  - b : 도착 도시
 *  - c : 필요한 비용
 */
public class Main_11404_플로이드 {
	static int n,m;
	static int map[][];
	static final int MAX_VALUE = 123456789;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		
		map = new int[n][n];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			map[a][b] = map[a][b]==0? c : Math.min(c, map[a][b]);
			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = map[i][j] == 0? MAX_VALUE : map[i][j];
			}
		}
		
		//풀이 
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if(k==i) continue;
				for (int j = 0; j < n; j++) {
					if(k==j || i==j) continue;
					
					if(map[i][k]!= MAX_VALUE 
							&& map[k][j] != MAX_VALUE
							&& map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = map[i][j] == MAX_VALUE? 0 : map[i][j];
				sb.append(a + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
