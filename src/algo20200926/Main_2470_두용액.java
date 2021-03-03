package algo20200926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_두용액 {
	static int N;
	static int arr[];
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int sp = 0;
		int ep = N-1;
		int sum = 0;
		int ansR = 0;
		int ansC = 0;
		while(true) {
			sum = arr[sp]+arr[ep];
			if(min ==0) break;
			if(sp == ep) break;
			
			if(Math.abs(sum) < min) {
				min = Math.abs(arr[sp]+arr[ep]);
				ansR = arr[sp];
				ansC = arr[ep];
			}
			
			if(sum<0) {
				sp++;
			}else {
				ep--;
			}
			
			//-3 -1 1 
		}
		System.out.println(ansR +" "+ansC);
		
	}

}
