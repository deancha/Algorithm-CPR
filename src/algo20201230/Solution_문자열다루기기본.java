package algo20201230;

public class Solution_문자열다루기기본 {

	public static void main(String[] args) {
		System.out.println(solution("a123"));
	}
	static public boolean solution(String s) {
        if(s.length() ==4 || s.length()==6) {
        	try {
        		Integer.parseInt(s);
			} catch (Exception e) {
				return false;
			}
        }else {
        	return false;
        }
        return true;
    }
}
