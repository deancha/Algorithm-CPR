import java.util.Arrays;import javax.swing.event.AncestorEvent;

public class Solution_비밀지도 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {9, 20,28,18,11},new int[] {30,1,21,17,28})));
	}
	
	
    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
        	int a = arr1[i] | arr2[i];
        	String bi = Integer.toBinaryString(a);
        	String temp = "";
        	for (int j = 0; j < bi.length(); j++) {
				if(bi.charAt(j)=='0') {
					temp+=" ";
				}else {
					temp+="#";
				}
			}
        	answer[i]= temp;
        }
        return answer;
    }

}
