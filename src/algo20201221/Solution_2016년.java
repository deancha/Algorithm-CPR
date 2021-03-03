package algo20201221;

public class Solution_2016년 {
	static String[] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
	static int[] months = {31,29,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}
	
	static public String solution(int a, int b) {
        String answer = "";
        int sum = 4;
        for (int i = 0; i < a-1; i++) {
			sum+=months[i];
		}
        sum+=b;
        sum%=7;
        return days[sum];
    }

}
