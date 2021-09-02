package SubSetSumDP_Algorithm;

public class SubSetSumDP {
	
	public boolean FastSubSetSum(int arr[],int T) {
		int n = arr.length;
		//저장해놀 2차원 배열생성 M = memoization
		boolean M[][] = new boolean[n+1][T+1];
		M[n][0] = true;
		for(int t=0; t<T+1;t++)
			M[n][t] = false;
		
		for(int j=n-1; j>=1; j--) {
			M[j][0] = true;
			for(int t=1; t<arr[j]; t++) {
				M[j][t] = M[j+1][t];
			}
			for(int t=arr[j]; t<T+1; t++) {
				if(M[j+1][t] || M[j+1][t-arr[j]])
					M[j][t] = true;
				else
					M[j][t] = false;
			}
		}
		return M[1][T];
	}		
}
