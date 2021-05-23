package algorithm;

public class CoinCount {
	public int count(int k) {
		int [] coin = {1, 4, 7, 13, 28, 52, 91, 365}; 
		int [] count = new int[k+1];
		count[0] = 0;
		
		
		//초기 배열 큰값으로 초기화
		for(int j=1; j< k+1;j++) {
			count[j] = 100000;
		}

		for(int j=1; j < k+1; j++) {
			for(int i = 0; i < coin.length; i++) {
				if(j >= coin[i]) {
					int temp= count[j-coin[i]] + 1;
					count[j] = Math.min(temp, count[j]);
				}
			}
		}
		return count[k];
	}
}
