package algo20200917;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_14501_퇴사 {
	static int N;
	static int T[];
	static int P[];
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		T = new int[N];
		P = new int[N];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken()); 
			P[i] = Integer.parseInt(st.nextToken());
		}		
		dfs(0, 0, 0);
		System.out.println(max);
	}
	private static void dfs(int today, int sum, int lastpay) {
		
		if(today>N) {
			max = Math.max(max, sum-lastpay);
			return;
		}else if(today==N) {
			max = Math.max(max,sum);
			return;
		}
		
		
		dfs(today+T[today],sum+P[today],P[today]);	//상담을 해줄때
		dfs(today+1, sum, 0);//상담을 안해줄 수도 잇음 
	}
}
