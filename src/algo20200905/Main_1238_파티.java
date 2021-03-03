package algo20200905;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	
	static int N;
	static int M;
	static int X;
	static int graph[][];
	static final int maxV = 987654321;
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) -1;
		
		graph = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(graph[i], maxV);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int start_point = Integer.parseInt(st.nextToken()) -1;
			int end_point = Integer.parseInt(st.nextToken()) -1;
			int weight = Integer.parseInt(st.nextToken());
			
			graph[start_point][end_point] = weight;
		}
		//입력 끝
		
		//플로이드 와샬
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k==i) continue;
				for (int j = 0; j < N; j++) {
					if(k==j || i==j) continue;
					
					if(graph[i][k] != maxV
						&& graph[k][j] != maxV
						&& graph[i][j] > graph[i][k] + graph[k][j]
					  ) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
					
				}
			}
		}
		/*
		 * 다익스트라 -> 한개의 정점에서 끝까지 가는 최소비용
		 * 플로이드 -> 모든정점에 대해서 최소비용
		 * 1-2 + 2-1 -> 왔다갔다 최소비용
		 * 3-2 + 2-3 ->
		 * 4-2 + 2-4 -> 
		 */
		int result = 0;
		for (int i = 0; i < N; i++) {
			if(i==X) continue;
			result = Math.max(result, graph[i][X] + graph[X][i]);
		}
		System.out.println(result);
	}
}
