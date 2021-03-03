package algo20210115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두용액 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] liquors = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			liquors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquors);
		int s = 0;
		int e = N - 1;
		int minV = Integer.MAX_VALUE;
		
		int a1 = liquors[s];
		int a2 = liquors[e];
		
		while (true) {
			if (minV == 0)
				break;
			if (s == e)
				break;
			
			int sum = liquors[s] + liquors[e];
			
			if(Math.abs(sum)<minV) {
				a1 = liquors[s];
				a2 = liquors[e];
	
				minV = Math.abs(sum);
			}
			
			if(sum<0) {
				s++;
			}else {
				e--;
			}
		}
		System.out.println(a1+" "+a2);
	}

}
