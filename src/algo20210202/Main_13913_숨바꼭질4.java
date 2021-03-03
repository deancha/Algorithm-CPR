package algo20210202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {
	static int N;
	static int K;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur==K) {
				break;
			}
			
		}
		
	}


}
