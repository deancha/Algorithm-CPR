package algo20200905;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1015_수열정렬 {

	static int N;
	static int[] A;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		N = Integer.parseInt(in.readLine());
		A = new int[N];
		
		List<Sequence> list = new LinkedList<>();
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			
			list.add(new Sequence(i,Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N-2; i++) {
			
			sb.append(list.get(i).idx +" ");
		}
		
		sb.append(list.get(N-1).idx + " ");
		sb.append(list.get(N-2).idx + " ");
		System.out.println(sb.toString());
		
	}
	
	static class Sequence implements Comparable<Sequence>{
		int idx;
		int value;
		
		public Sequence() {}
		public Sequence(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		@Override
		public int compareTo(Sequence o) {
			return -Integer.compare(this.value, o.value);
		}
	}

}
