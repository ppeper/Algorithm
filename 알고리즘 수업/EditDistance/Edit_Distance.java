package EditDistance;

public class Edit_Distance {
//	EditDistance를 구하라
//	String A를 String B로 변환하기 위해 필요한 최소 횟수의 편집연산
//		insertion(글자 하나 추가)
//		delection(글자 하나 삭제)
//		substitution(글자 하나를 다른 것으로 수정)	
	public int EditDistance(String A, String B) {
		int ins,del,rep,temp;
		int m = A.length();
		int n = B.length();
		int Edit[][] = new int[m+1][n+1];
		
		for(int j=0; j<n+1; j++) {
			Edit[0][j] = j;
		}
		
		for(int i=1; i<m+1; i++) {
			Edit[i][0] = i;
			for(int j=1; j<n+1; j++) {
				ins = Edit[i][j-1] + 1;
				del = Edit[i-1][j] + 1;
				if((A.charAt(i-1) == B.charAt(j-1))) {
					rep = Edit[i-1][j-1];
				}
				else {
					rep = Edit[i-1][j-1] + 1;
				}
				temp = Math.min(ins, del);
				Edit[i][j] = Math.min(temp,rep);
			}
		}
		return Edit[m][n];
	}
}
