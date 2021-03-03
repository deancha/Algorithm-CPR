package algo20201230;

public class Solution_가운데글자가져오기 {

	public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}
	static public String solution(String s) {
        String answer = "";
        int len = s.length();
        int mid = len/2;
        if(len>=2) {
        	if(len%2==0) {
        		answer = s.substring(mid-1,mid+1);
        	}else {
        		answer = s.substring(mid,mid+1);
        	}
        	
        }else {
        	answer=s;
        }
        return answer;
    }

}
