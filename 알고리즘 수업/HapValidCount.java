package algorithm;

public class HapValidCount {
	public int count(int n) {
		//�迭 ����
		int [] count = new int[n];
		//�迭 �ʱⰪ ����
		count[0] = 1;
		count[1] = 2;
		count[2] = 4;
		
		for(int i=3; i<n; i++) {
			count[i] = count[i-1] + count[i-2] + count[i-3];
		}
		
		return count[n-1];
	}
}
