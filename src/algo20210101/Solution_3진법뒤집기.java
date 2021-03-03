package algo20210101;

public class Solution_3진법뒤집기 {

	public static void main(String[] args) {
		System.out.println(solution(45));
	}
	
    static public int solution(int n) {
    	StringBuilder sb= new StringBuilder(20);
    	while(n>=1) {
    		sb.insert(0, n%3);
    		n /= 3;
    	}
    	String reverseStr = sb.reverse().toString();
    	
    	return Integer.parseInt(reverseStr,3);
    }
}
