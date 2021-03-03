package algo20210202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {
	static int N;
	static int M;
	static int[] arr;
	static int diff;
	static int minV;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		diff = 100000;
		minV = 100000;
		dfs(0,0,0);
		System.out.println(minV);
	}
	private static void dfs(int cur, int cnt, int sum) {
		if(sum>M) {
			return;
		}
		if(cnt==3) {
			if(diff>Math.abs(M-sum)) {
				diff= Math.abs(M-sum);
				minV = sum;
			}
			return;
		}
		
		for (int i = cur; i < N; i++) {
			dfs(i+1,cnt+1,sum+arr[i]);
		}
	}

}
