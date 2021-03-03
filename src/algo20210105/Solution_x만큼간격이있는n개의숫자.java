package algo20210105;

public class Solution_x만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		System.out.println(solution(2, 5));
	}
    static public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0]=x;
        for (int i = 1; i < n; i++) {
			answer[i] = answer[i-1]+x;
		}
        return answer;
    }
}
