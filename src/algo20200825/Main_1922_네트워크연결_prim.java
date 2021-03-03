package algo20200825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//크루스칼 방법으로 풀어보기 
public class Main_1922_네트워크연결_prim {
	
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static boolean visited[];	// 정점 방문 체크
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		visited = new boolean[N];
		ArrayList<Node>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}	//초기화 끄읏
		
		for (int i = 0; i< N; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			list[v1].add(new Node(v1,v2,w));
			list[v2].add(new Node(v2,v1,w));
		}
		
		visited[0] = true;
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.addAll(list[0]);
		
		int result = 0; 
		int cntE = 0;
		
		while(!queue.isEmpty()) {
			
			if(cntE == N-1) {
				break;
			}
			Node node = queue.poll();
			int v1 = node.v1;
			int v2 = node.v2;
			int w = node.w;
			
			if(visited[v2]) {
				continue;
			}
			
			cntE++;
			result+=w;
			visited[v2]= true;
			queue.addAll(list[v2]);
			
		}
		System.out.println(result);
	}
	
	
	static class Node implements Comparable<Node> {
		int v1;
		int v2;
		int w;

		public Node() {
		}
		
		public Node(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
		@Override
		public int compareTo(Node that) {
			
			return Integer.compare(this.w, that.w);
		}
	}

}
