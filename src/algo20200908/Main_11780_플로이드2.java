package algo20200908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11780_플로이드2 {
	static int[][] dist;
	static int n;	//도시의 개수
	static int m;	//버스의 갯수
	static int maxV = 987654321;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(in.readLine());
		m = Integer.parseInt(in.readLine());
		dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], maxV);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = dist[a][b] == maxV? c: Math.min(dist[a][b], c);
		}
		
		ArrayList<Integer> list[][] = new ArrayList[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				if(k==i) continue;
				for (int j = 0; j < n; j++) {
					if(k==j || i==j) continue;
					if(dist[i][k]!=maxV 
						&& dist[k][j] != maxV
						&& dist[i][j] > dist[i][k] + dist[k][j]
					) {
						list[i][j].add(k);
						dist[i][j] = dist[i][k] + dist[k][j];
					}
						
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = dist[i][j] == maxV? 0:dist[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
			}
		}
	}

}
