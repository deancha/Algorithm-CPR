package algo20201230;

import java.util.Arrays;

public class Solution_소수찾기 {

	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(5));
	}
	
	static public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[n+1];
        Arrays.fill(check, true);
        check[0] = check[1] = false;
        
        for(int i=2; i*i<=n; i+=1) {
            for(int j=i*i; j<=n; j+=i) {
                check[j] = false;        //2를 제외한 2의 배수 false
            }
        }
        
        for (int i = 0; i <= n; i++) {
			if(check[i]) {
				answer++;
			}
		}
        return answer;
    }
}
