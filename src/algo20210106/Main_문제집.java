package algo20210106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_문제집 {
	static int N;
	static int M;
	static int[] cnt;
	public static void main(String[] args) throws Exception	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = new int[N+1];
		List<Integer> list[] = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			cnt[e]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if(cnt[i]==0) {
				pq.offer(i);
			}
		}
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");
			
			for (int i = 0; i < list[cur].size(); i++) {
				if(--cnt[list[cur].get(i)]==0) {
					pq.add(list[cur].get(i));
				}
			}
		}
		
		System.out.println(sb);
	}

}
