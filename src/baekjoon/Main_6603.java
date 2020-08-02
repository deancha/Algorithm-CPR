package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중복되면 안됨 -> 조합문제임 -> 조합문제 어캐 풀더라? -> 좋은 습관 굳굳
public class Main_6603 {
	
	static int[] num, lotto;
	static int k;
	public static void main(String[] args) throws Exception{
			
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			
			k= Integer.parseInt(st.nextToken());
			
			if(k==0) {
				break;
			}
			
			num = new int[k];
			lotto = new int[6];
			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println();
			
		}
		
	}
	private static void dfs(int cnt, int cur) {
		
		if(cnt==6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(lotto[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = cur; i < k; i++) {
			lotto[cnt]=num[i];
			dfs(cnt+1,i+1);
		}
		
	}

}
