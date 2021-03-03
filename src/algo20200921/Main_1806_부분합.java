package algo20200921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sp = 0, ep = 0, sum=0;
		
		while(true) {
			if(sum>=S) {
				if(sp>=N) break;
				min = Math.min(min, ep-sp);
				sum -= arr[sp++];
			}else{
				if(ep>=N) break;
				sum += arr[ep++];
			}
			
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("0");
		}else {
			System.out.println(min);
		}
	}

}
