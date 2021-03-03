package algo20201230;

public class Solution_핸드폰번호가리기 {

	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
	}
	
    static public String solution(String phone_number) {
    	int len = phone_number.length();
    	
    	
        String answer = "";
        for (int i = 0; i < len-4; i++) {
        	answer += "*";
        		
		}
        answer += phone_number.substring(len-4,len);
        return answer;
    }

}
