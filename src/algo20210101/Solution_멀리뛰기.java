package algo20210101;

public class Solution_멀리뛰기 {
	static long[] memo;
	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(3));
		
	}
	
    static public long solution(int n) {
    	memo = new long[2001];
        long answer = dfs(n);
    	return answer;
    }

	private static long dfs(int n) {
		if(n<=1) {
			return 1;
		}
		if(memo[n] !=0) {
			return memo[n];
		}
		memo[n] =(dfs(n-2)%1234567+dfs(n-1)%1234567)%1234567; 
		return memo[n];
	}

}
