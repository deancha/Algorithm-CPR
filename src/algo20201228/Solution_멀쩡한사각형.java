package algo20201228;

public class Solution_멀쩡한사각형 {

	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}
	
	static public long solution(int w, int h) {

		long answer =0;
        //세로가 긴 직사가곃ㅇ
		
        if(w>h) {
        	int temp = h;
        	h =w ;
        	w = temp;
        }
        
        
        
        if(w==h) {
        	answer = w*h-w;
        }else {
        	if(h%w==0) {
        		answer = w*h - (h/w)*w;
        	} else {      		
        		answer = w*h - (h/w+1)*w;
        	}
        }
        
        if(w==1 || h==1) {
        	answer=0;
        }
        return answer;
    }

}
