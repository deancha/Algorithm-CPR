package algo20200825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//크루스칼 방법으로 풀어보기 
public class Main_1922_네트워크연결_kruskal {
	
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int[] parents;	//유니온 파인드를 위해
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		
		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			makeSet(i);			
		}
		
		List<Node> list = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			list.add(new Node(v1,v2,w));
		}
		
		Collections.sort(list);	//간선들을 오름차순으로 정리
		
		
		int min = 0;
		int cntE = 0;
		for (int i = 0; i < list.size(); i++) {
			
			if(cntE == N-1) {
				break;
			}
			
			Node node = list.get(i);
			int v1 = node.v1;
			int v2 = node.v2;
			int w = node.w;
			
			if(findSet(v1)==findSet(v2)) {
				continue;
			}
			
			unionSet(v1, v2);
			cntE++;
			min += w;
					
		}
		
		System.out.println(min);
		
	}
	
	static void makeSet(int x) {
		
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(x==parents[x]) {
			return x;
		}
		return findSet(parents[x]);
	}
	
	static void unionSet(int x, int y) {	
		parents[findSet(y)] = findSet(x);
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
