package algo20201221;

public class Solution_스킬트리 {
	
	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        top:
        for (String trees : skill_trees) {
        	int idx = 0;
 			for (int i = 0; i < trees.length(); i++) {		
 				
 				//CBD
 				
 				//BACDE
 				
				if(skill.contains(Character.toString(trees.charAt(i)))) {
					if(skill.charAt(idx)==trees.charAt(i)) {
						idx++;
					}
					for (int j = idx; j < skill.length(); j++) {
						if(skill.charAt(j)==trees.charAt(i)) {
							continue top;
						}
					}
					if(idx>skill.length()) {
						break;
					}
				}
				
			}
			answer++;
		}
        return answer;
    }

}
